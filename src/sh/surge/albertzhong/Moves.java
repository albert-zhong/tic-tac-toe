package sh.surge.albertzhong;

import java.util.Scanner;

/**
 * Created by Albert on 4/24/2016.
 */
public class Moves {
    public static int[] turns(char[][] board) {

        Scanner input = new Scanner(System.in);
        String move = input.nextLine();

        while (!isMoveValid(move, board)) {
            System.out.println("Make a valid move: ");
            move = input.nextLine();
        }

        return posConvert(move);

    }

    // Converts a move input (e.g a1) into a number array (0,0)
    private static int[] posConvert (String move) {
        char[] charMove = move.toCharArray();

        int[] numMove = new int[2];
        numMove[0] = charMove[0] - 'a';
        numMove[1] = charMove[1] - '1';

        return numMove;

    }

    /**
     * Check if the move string is valid
     * @param move
     * @return true if the move string is valid, otherwise false
     */
    private static boolean isMoveValid(String move, char[][] board) {

        if (move.length() != 2) {
            return false;
        }

        char first = move.charAt(0);
        char second = move.charAt(1);

        if (first != 'a' && first != 'b' && first != 'c') {
            return false;
        }

        if (second != '1' && second != '2' && second != '3') {
            return false;
        }

        for (int col = 0; col < 3; col++)
            for (int row = 0; row < 3; row ++) {
                int[] numMove = posConvert(move);
                if ( board[numMove[0]][numMove[1]] != '=' ) {
                    return false;
                }
            }

        return true;
    }

}