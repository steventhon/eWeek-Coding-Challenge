import java.util.*;

public class Connect4Runner {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Connect4 game = new Connect4();
        while (!game.checkWin() && !game.isBoardFull())
        {
            game.switchPlayer();
            game.printBoard();
            System.out.println("Enter row to insert piece (0-" + (game.ROWS - 1) +")");
            int col = s.nextInt();
            if (game.canInsert(col))
            {
                game.insert(col);
            }
            else
            {
                System.out.println("Column is full.");
            }
        }
        game.printBoard();
        if (game.checkWin())
        {
            System.out.println(game.getCurPlayer() + " wins!");
        }
        else
        {
            System.out.println("Draw!");
        }
    }
}
