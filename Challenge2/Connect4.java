public class Connect4
{
    public final static int ROWS = 7;
    public final static int COLS = 7;
    public final static int WIN = 4;
    private char curPlayer = 'X';
    private char[][] board;
    public Connect4()
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
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < ROWS; i++)
        {
            System.out.print(i + " ");
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

    public void switchPlayer()
    {
        if (curPlayer == 'X')
        {
            curPlayer = 'O';
        }
        else
        {
            curPlayer = 'X';
        }
    }

    public boolean canInsert(int col)
    {
        return board[0][col] == '-';
    }

    public void insert(int col)
    {
        int i;
        for (i = 1; i < ROWS; i++)
        {
            if (board[i][col] != '-')
            {
                break;
            }
        }
        board[i - 1][col] = curPlayer;
    }

    public boolean checkWinRow()
    {
        for (int i = 0; i < ROWS; i++) {
            int count = 0;
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == curPlayer)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count >= WIN)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinCol()
    {
        for (int j = 0; j < COLS; j++) {
            int count = 0;
            for (int i = 0; i < ROWS; i++) {
                if (board[i][j] == curPlayer)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count >= WIN)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinDiagTopDown()
    {
        for (int j = 0; j < COLS - WIN; j++) {
            int count = 0;
            for (int i = 0; i < ROWS - WIN; i++) {
                count = 0;
                for (int k = 0; k < WIN; k++)
                {
                    if (board[i + k][j + k] == curPlayer)
                    {
                        count++;
                    }
                    else
                    {
                        count = 0;
                    }
                    if (count >= WIN)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean checkWinDiagBottomUp()
    {
        for (int j = 0; j < COLS - WIN; j++) {
            int count = 0;
            for (int i = ROWS - 1; i > ROWS - 1 - WIN; i--) {
                count = 0;
                for (int k = 0; k < WIN; k++)
                {
                    if (board[i - k][j + k] == curPlayer)
                    {
                        count++;
                    }
                    else
                    {
                        count = 0;
                    }
                    if (count >= WIN)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkWin()
    {
        return checkWinCol() || checkWinRow() || checkWinDiagTopDown() || checkWinDiagBottomUp();
    }

    public char getCurPlayer()
    {
        return curPlayer;
    }

}
