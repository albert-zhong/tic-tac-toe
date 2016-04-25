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

        returnMove[0] = moveChar[0] - 97;
        returnMove[1] = moveChar[1] - 49;

        return returnMove;

    }

    public static boolean checkMove (String move) {

        char[] checkMove = move.toCharArray();
        return (checkMove[0] != 'a') && (checkMove[0] != 'b') && (checkMove[0] != 'c') || ((checkMove[1] != '1') && (checkMove[1] != '2') && (checkMove[1] != '3'));
    }

}
