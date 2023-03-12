/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 */
public class ValidSudoku {
    public static boolean checkValidSudoku(char[][] board) {
        int[] visited = null;
        for (int i = 0; i < board.length; i++) {
            visited = new int[board.length + 1];
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    visited[board[i][j] - '0']++;
                }
            }
            for (int j = 1; j < visited.length; j++) {
                if (visited[j] > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            visited = new int[board.length + 1];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    visited[board[j][i] - '0']++;
                }
            }
            for (int j = 1; j < visited.length; j++) {
                if (visited[j] > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                visited = new int[board.length + 1];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.') {
                            visited[board[i + k][j + l] - '0']++;
                        }
                    }
                }
                for (int k = 1; k < visited.length; k++) {
                    if (visited[k] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
