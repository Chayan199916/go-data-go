import java.util.ArrayList;
import java.util.List;

class LuckyNumbersInMatrix {
    public static void main(String[] args) {
        List<Integer> result = luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } });
        for (Integer i : result) {
            System.out.println(i + " ");
        }
    }

    private static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int rowMin, colIndex;
        for (int i = 0; i < matrix.length; i++) {
            rowMin = matrix[i][0];
            colIndex = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIndex = j;
                }
            }
            int k = 0;
            int colMax = rowMin;
            while (k < matrix.length) {
                if (matrix[k][colIndex] > colMax) {
                    colMax = matrix[k][colIndex];
                    break;
                }
                k++;
            }
            if (colMax == rowMin) {
                result.add(colMax);
            }
        }
        return result;
    }
}
/**
 * This's also called saddle point in matrix
 */