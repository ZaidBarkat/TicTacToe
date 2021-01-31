package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  /** initial variables */
  private String board;

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

    board = boardPassed;
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
