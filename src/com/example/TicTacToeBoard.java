package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  // initial variables
  private char[][] board;
  private int boardLength;

  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param boardPassed The string representing the board
   */
  public TicTacToeBoard(String boardPassed) {
    //checking for illegalArgumentExceptions if there is a problem with the string
    if (boardPassed == null || boardPassed.equals("") || boardPassed.length() < 9) {
      throw new IllegalArgumentException();
    }

    // checking if the given board is a perfect square
    double boardSize = boardPassed.length();
    double boardSquareRoot = Math.sqrt(boardSize);
    if ((boardSquareRoot - Math.floor(boardSquareRoot)) != 0) {
      throw new IllegalArgumentException();
    }

    // putting characters into two dimensional array
    boardPassed = boardPassed.toLowerCase();
    board = new char[(int) boardSquareRoot][(int) boardSquareRoot];
    int increment = 0;
    for (int  row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        board[row][column] = boardPassed.charAt(increment);
        increment++;
      }
    }

    boardLength = (int) boardSquareRoot;
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins).
   * Uses two helper methods to check horizontal and vertical wins
   *
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    // initial local variables created to check for unreachable states
    boolean xwin = false;
    boolean owin = false;
    int numberOfOs = 0;
    int numberOfXs = 0;

    // for statement checks if player has won in the horizontal or vertical directions
    // Also checks for two turns from one player
    for (int i = 0; i < boardLength; i++) {
      Character winnerRow = rowWin(i);
      Character winnerColumn = columnWin(i);

      if (winnerRow != null) {
        if (winnerRow == 'x') {
          xwin = true;
        } else if (winnerRow == 'o') {
          owin = true;
        }
      }

      if (winnerColumn != null) {
        if (winnerColumn == 'x') {
          xwin = true;
        } else if (winnerColumn == 'o') {
          owin = true;
        }
      }

      for (int j = 0; j < boardLength; j++) {
        if (board[i][j] == 'o') {
          numberOfOs++;
        } else if (board[i][j] == 'x') {
          numberOfXs++;
        }
      }
    }

    // Checks the diagonal for wins
    for (int d = 0; d < boardLength - 1; d++) {
      char spotInDiagonal = board[d][d];
      char nextInDiagonal = board[d + 1][d + 1];
      if (spotInDiagonal != nextInDiagonal) {
        break;
      }
      if (d == boardLength - 2) {
        if (spotInDiagonal == 'x') {
          xwin = true;
        } else if (spotInDiagonal == 'o') {
          owin = true;
        }
      }
    }

    // checks the anti-diagonal for wins
    for (int a = 0; a < boardLength - 1; a++) {
      char spotInAntiDiagonal = board[a][(boardLength - 1) - a];
      char nextInAntiDiagonal = board[a + 1][(boardLength - 1) - (a + 1)];
      if (spotInAntiDiagonal != nextInAntiDiagonal) {
        break;
      }
      if (a == boardLength - 2) {
        if (spotInAntiDiagonal == 'x') {
          xwin = true;
        } else if (spotInAntiDiagonal == 'o') {
          owin = true;
        }
      }
    }

    // checking is player took an extra turn
    if (Math.abs(numberOfOs - numberOfXs) > 1) {
      return Evaluation.UnreachableState;
    }

    // checking if two people won, else if some player had won
    if (xwin && owin) {
      return Evaluation.UnreachableState;
    } else if (xwin) {
      return Evaluation.Xwins;
    } else if (owin) {
      return Evaluation.Owins;
    }

    // if nothing is wrong with the board, than there was no winner
    return Evaluation.NoWinner;
  }

  /**
   * helper method created to check if a win is in a column.
   *
   * @param columnNumber the column being checked through the method
   * @return a character of the winning player
   */
  private Character columnWin(int columnNumber) {
    for (int row = 0; row < boardLength - 1; row++) {
      char spotInColumn = board[columnNumber][row];
      char nextInColumn = board[columnNumber][row + 1];
      if (spotInColumn != nextInColumn) {
        break;
      }
      if (row == boardLength - 2) {
        return spotInColumn;
      }
    }
    return null;
  }

  /**
   * helper method created to check if a win is in a row.
   *
   * @param rowNumber the row being checked through the method
   * @return a character of the winning player
   */
  private Character rowWin(int rowNumber) {
    for (int column = 0; column < boardLength - 1; column++) {
      char spotInRow = board[column][rowNumber];
      char nextInRow = board[column + 1][rowNumber];
      if (spotInRow != nextInRow) {
        break;
      }
      if (column == boardLength - 2) {
        return spotInRow;
      }
    }
    return null;
  }
}
