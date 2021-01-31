package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  /** initial variables */
  private char[][] board;
  private int boardLength;

  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param boardPassed The string representing the board
   */
  public TicTacToeBoard(String boardPassed) {
    if (boardPassed == null || boardPassed.equals("")) {
      throw new IllegalArgumentException();
    }

    /** checking if the given board is a perfect square. */
    double boardSize = boardPassed.length();
    double boardSquareRoot = Math.sqrt(boardSize);
    if ((boardSquareRoot - Math.floor(boardSquareRoot)) != 0) {
      throw new IllegalArgumentException();
    }

    /** putting characters into two dimensional array */
    board = new char[(int) boardSquareRoot][(int) boardSquareRoot];
    int increment = 0;
    for (int  row = 0; row < board.length; row++) {
      for (int column = 0; column < board[column].length; column++) {
        board[row][column] = boardPassed.charAt(increment);
        increment++;
      }
    }

    boardLength = (int) boardSquareRoot;
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins).
   *
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    return Evaluation.UnreachableState;
  }
}
