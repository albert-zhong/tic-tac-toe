package sh.surge.albertzhong;
import java.util.Scanner;

/**
 * Created by Albert on 4/24/2016.
 */
public class Moves {
    public static int[] turns() {

        Scanner input = new Scanner(System.in);
        String move = input.nextLine();

        while (checkMove(move)) {
            System.out.println("Make a valid move: ");
            move = input.nextLine();
        }

        return posConvert(move);

    }

    // Converts a move input (e.g a1) into a number array (0,0)
    public static int[] posConvert (String move) {
        char[] moveChar = move.toCharArray();

        int[] returnMove = new int[2];

        returnMove[0] = moveChar[0] - 'a';
        returnMove[1] = moveChar[1] - '1';

        return returnMove;

    }

    /**
     * Check if the move string is valid
     * @param move
     * @return true if the move string is valid, otherwise false
     */
    public static boolean checkMove (String move) {
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

        return true;
    }

}
