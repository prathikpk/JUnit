package com.Aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comm.Aurionpro.model.Board;
import comm.Aurionpro.model.Cell;
import comm.Aurionpro.model.CellAlreadyMarkException;
import comm.Aurionpro.model.InvalidCellLocation;
import comm.Aurionpro.model.MarkType;

public class BoardTest {

	Board board;

	@BeforeEach
	void creatingBoard() {
		board = new Board();
	}

	@Test
	void testCreateBoard_allNineCellsAreEmpty() {
		boolean expected = false;
		boolean actual = board.isBoardFull();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCellMark_ableToMarkAtSpecificLocation() {
		Board board1 = new Board();
		board1.setCellMark(0, MarkType.X);
		Cell[] expected = board1.getCells();
		
		board.setCellMark(0, MarkType.X);
		Cell[] actual = board.getCells();

		 assertArrayEquals(expected, actual);
	}

	@Test
	void testSetCellMark_throwsInvalidLocationExceptionForInvalidCellLocation() {
		
		assertThrows(InvalidCellLocation.class, ()->{
			board.setCellMark(20, MarkType.X);
		});
	}

	@Test
	void testIsBoardFull_checkTrueIfBoardIsFull() {
		boolean expected = true;
		for(int i=0;i<9;i++) {
			board.setCellMark(i, MarkType.X);
		}
		boolean actual = board.isBoardFull();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCellMark_throwsCellAlreadyMarkedExceptionIfCellMarkedTwice() {
		board.setCellMark(0, MarkType.O);
		assertThrows(CellAlreadyMarkException.class, ()->{
			board.setCellMark(0, MarkType.X);
		});
	}

}