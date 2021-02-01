package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("OoxxX..oO");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardXWins() {
    TicTacToeBoard board = new TicTacToeBoard("Xo.xO.x..");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWins() {
    TicTacToeBoard board = new TicTacToeBoard("x,.XX.oOo");
    assertEquals(Evaluation.Owins, board.evaluate());
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
    TicTacToeBoard board = new TicTacToeBoard("xx.<..]..ooxx");
  }

  @Test
  public void testValidFourByFourBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X...O...x.");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidFourByFourBoardWin() {
    TicTacToeBoard board = new TicTacToeBoard("X.O..x.Oo.X3.Y.x");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testTwoWinners() {
    TicTacToeBoard board = new TicTacToeBoard("oOOXxX...");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testTwoTurns() {
    TicTacToeBoard board = new TicTacToeBoard("O?o..X.O.");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testValidBoardWinDiagonal() {
    TicTacToeBoard board = new TicTacToeBoard("X.o.X!o.X");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardWinAntiDiagonal() {
    TicTacToeBoard board = new TicTacToeBoard("x.o.O.oQX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
}
