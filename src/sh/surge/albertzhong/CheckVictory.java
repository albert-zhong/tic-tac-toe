package sh.surge.albertzhong;

/**
 * Created by Albert on 4/24/2016.
 */
public class CheckVictory {
    public static String checkVictory (char[][] board) {

        int[][] numBoard = new int[3][3]; // Converts the actual board into a board with 1s (crosses) and 0s (circles)
        int sum = 0;

        for(int a=0; a<3; a++) {
            for(int b=0; b<3; b++) {
                if (board[a][b] == 'x') {
                    numBoard[a][b] = 1;
                } else if (board[a][b] == 'o') {
                    numBoard[a][b] = 0;
                } else {
                    numBoard[a][b] = 10;
                }
            }
        }

        // Decides every turn if a person has won, returns the appropriate value
        if ( (numBoard[0][0] + numBoard[0][1] + numBoard[0][2] == 3) || (numBoard[1][0] + numBoard[1][1] + numBoard[1][2] == 3) || (numBoard[2][0] + numBoard[2][1] + numBoard[2][2] == 3)) {
            return "cross";
        } else if ( (numBoard[0][0] + numBoard[1][0] + numBoard[2][0] == 3) || (numBoard[0][1] + numBoard[1][1] + numBoard[2][1] == 3) || (numBoard[0][2] + numBoard[1][2] + numBoard[2][2] == 3)){
            return "cross";
        } else if ( (numBoard[0][0] + numBoard[1][1] + numBoard[2][2] == 3) || (numBoard[0][2] + numBoard[1][1] + numBoard[2][0] == 3) ){
            return "cross";
        } else if ( (numBoard[0][0] + numBoard[0][1] + numBoard[0][2] == 0) || (numBoard[1][0] + numBoard[1][1] + numBoard[1][2] == 0) || (numBoard[2][0] + numBoard[2][1] + numBoard[2][2] == 0)) {
            return "circle";
        } else if ( (numBoard[0][0] + numBoard[1][0] + numBoard[2][0] == 0) || (numBoard[0][1] + numBoard[1][1] + numBoard[2][1] == 0) || (numBoard[0][2] + numBoard[1][2] + numBoard[2][2] == 0)){
            return "circle";
        } else if ( (numBoard[0][0] + numBoard[1][1] + numBoard[2][2] == 0) || (numBoard[0][2] + numBoard[1][1] + numBoard[2][0] == 0) ) {
            return "circle";
        } else { // Any game that had a tie will add up to 5
            for (int a=1; a<3; a++) {
                for (int b=1; b<3; b++) {
                    sum = sum + numBoard[a][b];
                }
            }
            if (sum == 5) {
                return "tie";
            } else {
                return "none";
            }
        }

    }
}
