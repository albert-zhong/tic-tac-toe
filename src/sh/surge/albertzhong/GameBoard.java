package sh.surge.albertzhong;

/**
 * Created by Albert on 4/24/2016.
 */
public class GameBoard {
    public static void main (String args[]) {

        // Test

        CheckVictory checkVictory = new CheckVictory();
        Moves moves = new Moves();
        int[] result;
        int turnPos;
        int playerTurn;
        String sideTurn;

        char[][] board = new char[3][3];
        board[0][0] = '='; // a1
        board[0][1] = '='; // a2
        board[0][2] = '='; // a3
        board[1][0] = '='; // b1
        board[1][1] = '='; // b2
        board[1][2] = '='; // b3
        board[2][0] = '='; // c1
        board[2][1] = '='; // c2
        board[2][2] = '='; // c3

        System.out.println(showBoard(board));
        System.out.println(">> P1: Crosses ");

        for(int i=0; i<100; i++) {
            result = moves.turns();
            turnPos = i;
            if (turnPos%2 == 0) {
                playerTurn = 2;
                sideTurn = "Circles";
            } else {
                playerTurn = 1;
                sideTurn = "Crosses";
            }

            if (i % 2 == 0) {
                board[result[0]][result[1]] = 'x';
            } else {
                board[result[0]][result[1]] = 'o';
            }
            System.out.println(">> P" + playerTurn + ": " + sideTurn + "\n>> Move: " + (i+2) + "\n" + showBoard(board));

            if (checkVictory.checkVictory(board) == "cross") {
                System.out.println(">> Crosses (P1) wins!");
                break;
            } else if (checkVictory.checkVictory(board) == "circle") {
                System.out.println(">> Circles (P2) wins!");
                break;
            } else if (checkVictory.checkVictory(board) == "tie") {
                System.out.println(">> Game ends in tie!");
                break;
            }
        }
    }

    public static String showBoard (char[][] board) {
        return "  1 2 3\na " + board[0][0] + " " + board[0][1] + " " + board[0][2] + "\nb " + board[1][0] + " " + board[1][1] + " " + board[1][2] + "\nc " + board[2][0] + " " + board[2][1] + " " + board[2][2];
    }

}
