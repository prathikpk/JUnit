package com.Aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import comm.Aurionpro.model.Board;
import comm.Aurionpro.model.Cell;
import comm.Aurionpro.model.Game;
import comm.Aurionpro.model.Player;
import comm.Aurionpro.model.ResultAnalyzer;
import comm.Aurionpro.model.ResultType;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameTest {

	Game game;
	Board board;
	Player[] players = { new Player("john"), new Player("Sam") };
	ResultAnalyzer analyzer;

	@BeforeEach
	void init() {
		analyzer = new ResultAnalyzer();
		board = new Board();
		game = new Game(players);

	}

	@Test
	void testPlay_checkPlayerChangeIfProgress() {

		game.play(1);

		if (analyzer.analyzeResult() == ResultType.PROGRESS) {

			assertEquals("Sam", game.getcurrentPlayer().getName());
		}

	}

	@Test
	@DisplayName("check WIn ")
	void testAnalyzeResult_CheckTestHorizontalWin1Row() {

//		 X X X               0  1  2
//		 O X O    ---->      3  4  5
//		 X O O               6  7  8

		
		game.play(0); game.play(8); game.play(1);                     
		
		game.play(3); game.play(2); game.play(7);
		
		game.play(4); game.play(5); game.play(6);

		
		Cell[] cells = game.getBoard().getCells();
		

		
		for (Cell c : cells)
			System.out.println(c.getMark());

		assertEquals(ResultType.WIN, game.getResult());

	}
}