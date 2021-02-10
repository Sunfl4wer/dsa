package chapter3;

public class TicTacToe {
  public static final int X = 1, O = -1;
  public static final int EMPTY = 0;
  private int board[][] = new int[3][3];
  private int player;

  public TicTacToe() {
    clearBoard();
  }

  public void clearBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = EMPTY;
      }
    }
    player = X;
  }

  public void putMark(final int i,
                      final int j) throws IllegalArgumentException {
    if (i < 0 || i > 2 || j < 0 || j > 2) {
      throw new IllegalArgumentException("Invalid board position");
    }
    if (board[i][j] != EMPTY) {
      throw new IllegalArgumentException("Board position occupied");
    }
    if (isWin(-player)) {
      throw new IllegalArgumentException("The game is over! Please announce the result.");
    }
    board[i][j] = player;
    player = -player;
  }

  public boolean isWin(final int mark) {
    return (
        (board[0][0] + board[0][1] + board[0][2] == mark * 3)
            || (board[1][0] + board[1][1] + board[1][2] == mark * 3)
            || (board[2][0] + board[2][1] + board[2][2] == mark * 3)
            || (board[0][0] + board[1][0] + board[2][0] == mark * 3)
            || (board[0][1] + board[1][1] + board[2][1] == mark * 3)
            || (board[0][2] + board[1][2] + board[2][2] == mark * 3)
            || (board[0][0] + board[1][1] + board[2][2] == mark * 3)
            || (board[2][0] + board[1][1] + board[0][2] == mark * 3)
    );
  }

  public int winner() {
    if (isWin(X)) {
      return X;
    } else if (isWin(O)) {
      return O;
    } else {
      return 0;
    }
  }

  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        switch (board[i][j]) {
          case X:
            sb.append("X");
            break;
          case O:
            sb.append("O");
            break;
          case EMPTY:
            sb.append(" ");
            break;
        }
        if (j < 2) {
          sb.append("|");
        }
      }
      if (i < 2) {
        sb.append("\n-----\n");
      }
    }
    return sb.toString();
  }

  public static void main(final String[] args) {
    final TicTacToe game = new TicTacToe();

    game.putMark(1,1); // X
    game.putMark(0,0); // O
    game.putMark(0,2); // X
    game.putMark(2,0); // O
    game.putMark(1,0); // X
    game.putMark(2,1); // O
    game.putMark(1,2); // X
//    game.putMark(2,2); // O
    System.out.println(game.toString());
    int winningPlayer = game.winner();
    String[] outcome = {"0 wins", "Tie", "X wins"};
    System.out.println(outcome[1 + winningPlayer]);
  }
}
