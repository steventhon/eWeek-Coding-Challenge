public class Connect4
{
  public final static int ROWS = 7;
  public final static int COLS = 7;
  private char[][] board;
  public Connect4
  {
    board = new char[ROWS][COLS];
    initBoard();
  }
  
  public void initBoard()
  {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        board[i][j] = '-';
      }
    }
  }
  
  public void printBoard()
  {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }
  
  public boolean isBoardFull()
  {
    boolean isFull = true;
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] == '-')
        {
          isFull = false;
        }
      }
    }
    return isFull;
  }
  
  public boolean canInsert(int col)
  {
    return board[0][col] == '-';
  }
  
  public void insert(int col, char player)
  {
    for (int i = 1; i < ROWS; i-- )
    {
      if (board[i][col] != '-')
      {
        board[i - 1][col] = player;
      }
    }
  }
  
  public boolean checkWinRow(char player)
  {
    int count = 0;
    for (int i = 0; i < ROWS; i++) {
      count = 0;
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] == player)
        {
          count++;
        }
        else
        {
          count = 0;
        }
        if (count >= 4)
        {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean checkWinCol(char player)
  {
    int count = 0;
    for (int j = 0; j < COLS; i++) {
      count = 0;
      for (int i = 0; i < ROWS; j++) {
        if (board[i][j] == player)
        {
          count++;
        }
        else
        {
          count = 0;
        }
        if (count >= 4)
        {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean checkWin(char player)
  {
    return checkWinCol(player) && checkWinRow(player) &&
      checkWinDiagTopDown(player) && checkWinDiagBottomUp(player);
  }
  
}
