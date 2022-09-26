package com.Aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import comm.Aurionpro.model.Board;
import comm.Aurionpro.model.Cell;
import comm.Aurionpro.model.CellAlreadyMarkException;
import comm.Aurionpro.model.MarkType;
import comm.Aurionpro.model.ResultAnalyzer;
import comm.Aurionpro.model.ResultType;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResultAnalyzerTest {

	ResultAnalyzer resultAnalyzer;
	Board board;

	@BeforeEach
	void init() {

		resultAnalyzer = new ResultAnalyzer();
		board = resultAnalyzer.getBoard();
	}

	@Test
	@DisplayName("Horizintal win check 1st row")
	void testAnalyzeResult_CheckTestHorizontalWin1Row() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[0].setMark(MarkType.X);
		cells[1].setMark(MarkType.X);
		cells[2].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Horizintal win check 2nd row")
	void testAnalyzeResult_CheckTestHorizontalWin2Row() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[3].setMark(MarkType.X);
		cells[4].setMark(MarkType.X);
		cells[5].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Horizintal win check 3rd row")
	void testAnalyzeResult_CheckTestHorizontalWin3Row() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[6].setMark(MarkType.X);
		cells[7].setMark(MarkType.X);
		cells[8].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Vertical win check 1st column")
	void testAnalyzeResult_CheckTestVerticalWin1Column() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[0].setMark(MarkType.X);
		cells[3].setMark(MarkType.X);
		cells[6].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Vertical win check 1st column")
	void testAnalyzeResult_CheckTestVerticalWin2Column() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[1].setMark(MarkType.X);
		cells[4].setMark(MarkType.X);
		cells[7].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Vertical win check 3rd column")
	void testAnalyzeResult_CheckTestVerticalWin3Column() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[2].setMark(MarkType.X);
		cells[5].setMark(MarkType.X);
		cells[8].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Diagonal 0-4-8 win check")
	void testAnalyzeResult_CheckTestDiagonal1Win() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[0].setMark(MarkType.X);
		cells[4].setMark(MarkType.X);
		cells[8].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Diagonal 2-4-6 win check")
	void testAnalyzeResult_CheckTestDiagonal2Win() throws CellAlreadyMarkException {

//		 0 1 2
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();
		cells[2].setMark(MarkType.X);
		cells[4].setMark(MarkType.X);
		cells[6].setMark(MarkType.X);

		assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Draw  check")
	void testAnalyzeResult_CheckTestDraw() throws CellAlreadyMarkException {

//		 0 1 2   
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();

		cells[0].setMark(MarkType.O);
		cells[1].setMark(MarkType.X);
		cells[2].setMark(MarkType.O);

		cells[3].setMark(MarkType.O);
		cells[4].setMark(MarkType.X);
		cells[5].setMark(MarkType.X);

		cells[6].setMark(MarkType.X);
		cells[7].setMark(MarkType.O);
		cells[8].setMark(MarkType.X);

		assertEquals(ResultType.DRAW, resultAnalyzer.analyzeResult());

	}

	@Test
	@DisplayName("Progress  check")
	void testAnalyzeResult_CheckTestProgres() throws CellAlreadyMarkException {

//		 0 1 2   
//		 3 4 5
//		 6 7 8

		Cell[] cells = board.getCells();

		cells[0].setMark(MarkType.O);
		cells[1].setMark(MarkType.X);
		cells[2].setMark(MarkType.O);

		cells[3].setMark(MarkType.O);
		cells[4].setMark(MarkType.X);
		cells[5].setMark(MarkType.X);

		assertEquals(ResultType.PROGRESS, resultAnalyzer.analyzeResult());

	}

}