public class RotateImage90DegreeClockwise {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2 }, { 3, 4 } };
        rotate(matrix);
    }

    private static void rotate(int[][] matrix) {
        /**
         * col reverse
         */
        for (int i = 0; i < matrix.length; i++) {
            int top = 0;
            int bottom = matrix[i].length - 1;
            while (top < bottom) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
                top++;
                bottom--;
            }
        }

        /**
         * transpose
         */
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /**
         * display
         */
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
