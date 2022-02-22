class Main {
    public static void main(String[] args) {
        int n = 5;
        boolean board[][] = new boolean[n][n];
        System.out.println(getAns(board, 0));
    }

    private static int getAns(boolean[][] board, int row) {
        /**
         * We are checking row by row so if we have gone beyond the last row, we should
         * have placed all queens so we should display the board
         */
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        /**
         * for each row, we going to traverse through all columns and check if that cell
         * is safe or not
         */
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                /**
                 * if that cell is safe for placing a queen we mark that cell with true value
                 * and start to check in the next row
                 */
                board[row][col] = true;
                count += getAns(board, row + 1);
                /**
                 * this is the part where backtracking taking place. so if at any point we find
                 * that we have chosen a wrong choice so we start reversing back to the previous
                 * row and change all those cells which have been changed previously
                 */
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        /** this is for vertical checking */
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }
        /**
         * this is for left diagonal checking
         * we will keep going until we reach the left most wall
         */
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i])
                return false;
        }
        /**
         * this is for right diagonal checking
         * we will keep going until we reach the right most wall
         */
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i])
                return false;
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                if (cell)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
}