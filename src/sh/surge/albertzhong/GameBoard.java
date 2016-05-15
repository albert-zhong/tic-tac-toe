package sh.surge.albertzhong;

import static sh.surge.albertzhong.AI.prompt;

/**
 * Created by Albert on 4/24/2016.
 */
public class GameBoard {
    public static void main (String args[]) {

        int[] result;
        int playerTurn;
        String sideTurn;

        char[][] board = new char[3][3];
        // Initialize the board
        for (int col = 0; col < 3; col++)
            for (int row = 0; row < 3; row ++) {
                board[col][row] = '=';
            }

        boolean gameType = prompt();
        printBoard(board);
        System.out.println(">> P1: Crosses ");

        for(int i=0; i<100; i++) {

            if ( i >= 9 ) {
                System.out.println("<< Game ends in tie! >>");
                break;
            }

            if (i%2 == 0) {
                playerTurn = 2;
                sideTurn = "Circles";
            } else {
                playerTurn = 1;
                sideTurn = "Crosses";
            }

            // If it's an AI game, it will direct who should make the move (AI or human)
            if (!gameType) {
                result = Moves.turns(board);
            } else {
                if (playerTurn == 1) { // If the Crosses (human) player is going
                    result = Moves.turns(board);
                } else {
                    result = AI.createDecision(board);
                }
            }

            if (i % 2 == 0) {
                board[result[0]][result[1]] = 'x';
            } else {
                board[result[0]][result[1]] = 'o';
            }
            System.out.println(">> P" + playerTurn + ": " + sideTurn + "\n>> Move: " + (i+2) + "\n");
            printBoard(board);

            if ( CheckVictory.checkVictory(board).equals("cross") ) {
                System.out.println("<< Crosses (P1) wins! >>");
                break;
            }
            if ( CheckVictory.checkVictory(board).equals("circle") ) {
                System.out.println("<< Circles (P2) wins! >>");
                break;
            }

        }
    }

    /**
     * Print out the board status
     * @param board
     */
    public static void printBoard (char[][] board) {
        System.out.printf("  1 2 3\n");
        System.out.printf("a %c %c %c\n", board[0][0], board[0][1], board[0][2]);
        System.out.printf("b %c %c %c\n", board[1][0], board[1][1], board[1][2]);
        System.out.printf("c %c %c %c\n", board[2][0], board[2][1], board[2][2]);
    }

}