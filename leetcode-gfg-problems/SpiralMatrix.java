import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][] { {} });
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            /**
             * row (left -> right)
             */
            for (int j = colStart; j <= colEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++;
            /**
             * column (top -> bottom)
             */
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            /**
             * row (right -> left)
             */
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            /**
             * column (bottom -> top)
             */
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}

/**
 * 1 2 3 10 4 5 6 11 7 8 9 12
 * 
 * rowStart = 0 = colStart rowEnd = 2, colEnd = 3 1 2 3 10; rowStart = 1 11 12;
 * colEnd = 2 9 8 7; rowEnd = 1 4; colStart = 1 5 6; rowStart = 2
 */