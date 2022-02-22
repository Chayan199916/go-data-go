class Main {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        knights(board, 0, 0, 3);
    }

    private static void knights(boolean[][] board, int row, int col, int knights) {
        /**
         * If all knights have been placed display the board and start checking for
         * another placements
         */
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        /**
         * We have reached the last row and have gone beyond the last cell
         */
        if (row == board.length - 1 && col == board.length)
            return;
        /**
         * If we have reached the last cell for a particular row so we should start from
         * next row
         */
        if (col == board.length) {
            knights(board, row + 1, 0, knights);
            return;
        }
        /**
         * If the current cell is safe to place the knight, mark that cell with true
         * value and check for next cell
         */
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        /** If that cell is not safe, check for next cell */
        knights(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2])
                return false;
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2])
                return false;
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1])
                return false;
        }
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1])
                return false;
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                if (cell)
                    System.out.print("K ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
}
