package sh.surge.albertzhong;

/**
 * Created by Albert on 4/24/2016.
 */
public class CheckVictory {

    /**
     * Check if the row has winning condition for 'x' or 'o'
     * @param board
     * @param row Row to check
     * @return
     */
    private static boolean checkRow(char[][] board, int row) {
        if (board[row][0] != 'x' && board[row][0] != 'o') {
            return false;
        }
        for (int i = 1; i < 3; i ++) {
            if (board[row][i] != board[row][0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the column has winning condition for 'x' or 'o'
     * @param board
     * @param col Column to check
     * @return
     */
    private static boolean checkCol(char[][] board, int col) {
        if (board[0][col] != 'x' && board[0][col] != 'o') {
            return false;
        }
        for (int i = 1; i < 3; i ++) {
            if (board[i][col] != board[0][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonal(char[][] board) {
        if (board[1][1] != 'x' && board[1][1] != 'o') {
            return false;
        }
        if ((board[0][0] == board[2][2]) && (board[0][0] == board[1][1])) {
            return true;
        }

        if ((board[0][2] == board[2][0]) && (board[0][2] == board[1][1])) {
            return true;
        }
        return false;
    }

    private static String getDisplayStringForSide(char side) {
        if (side == 'x') {
            return "cross";
        }
        if (side == 'o') {
            return "circle";
        }
        return null;
    }

    /**
     * Check who is winning
     * @param board
     * @return 'cross' if 'x' is winning, or 'circle' if 'o' is winning, or 'none' if neither is winning
     */
    public static String checkVictory (char[][] board) {
        for (int i = 0; i < 3; i ++) {
            if (checkRow(board, i)) {
                return getDisplayStringForSide(board[i][0]);
            }
            if (checkCol(board, i)) {
                return getDisplayStringForSide(board[0][i]);
            }
        }

        if (checkDiagonal(board)) {
            return getDisplayStringForSide(board[1][1]);
        }

        return "none";
    }
}
