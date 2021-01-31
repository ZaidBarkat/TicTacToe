package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardXWins() {
    TicTacToeBoard board = new TicTacToeBoard("OXXXOO...");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWins() {
    TicTacToeBoard board = new TicTacToeBoard("OOOXX.X..");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testXGreaterThanThree() {
    TicTacToeBoard board = new TicTacToeBoard("XXXXXXXXX");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testOGreaterThanThree() {
    TicTacToeBoard board = new TicTacToeBoard("OOOOOOOOO");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullBoard() {
    TicTacToeBoard board = new TicTacToeBoard(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyString() {
    TicTacToeBoard board = new TicTacToeBoard("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNonPerfectSquareString() {
    TicTacToeBoard board = new TicTacToeBoard("xx.......ooxx");
  }

  @Test
  public void testValidFourByFourBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X.........");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidFourByFourBoardXWins() {
    TicTacToeBoard board = new TicTacToeBoard("OXXXxO..o.......");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidFourByFourBoardOWins() {
    TicTacToeBoard board = new TicTacToeBoard("OOOoX.Xx........");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
}
