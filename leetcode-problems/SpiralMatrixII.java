class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] result = generateMatrix(6);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowStart = 0, rowEnd = result.length - 1;
        int colStart = 0, colEnd = result[0].length - 1;
        int start = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            /**
             * row (left -> right)
             */
            for (int j = colStart; j <= colEnd; j++) {
                result[rowStart][j] = start++;
            }
            rowStart++;
            /**
             * column (top -> bottom)
             */
            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = start++;
            }
            colEnd--;
            /**
             * row (right -> left)
             */
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    result[rowEnd][j] = start++;
                }
                rowEnd--;
            }
            /**
             * column (bottom -> top)
             */
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result[i][colStart] = start++;
                }
                colStart++;
            }
        }
        return result;
    }
}
