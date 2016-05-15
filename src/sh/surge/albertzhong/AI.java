package sh.surge.albertzhong;

import java.util.Scanner;

/**
 * Created by Albert on 4/25/2016.
 */
public class AI {
    public static boolean prompt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Play against an AI? yes/no");
        String gameType = input.nextLine();

            while ( !gameType.equals("yes") && !gameType.equals("no") ) {
                System.out.println("Only yes/no:");
                gameType = input.nextLine();
            }

            return gameType.equals("yes");
    }

    public static int[] createDecision(char[][] board) {
        int[] move = new int[2];
        move[0] = 1;
        move[1] = 2;

        return move;

    }
}
