import java.util.List;
import java.util.ArrayList;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(int[][] matrix) {
        List<List<Integer>> cells = new ArrayList<List<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    cells.add(cell);
                }
            }
        }
        for (List<Integer> cell : cells) {
            int row = cell.get(0);
            int col = cell.get(1);
            for (int j = 0; j < matrix[0].length; j++)
                matrix[row][j] = 0;
            for (int i = 0; i < matrix.length; i++)
                matrix[i][col] = 0;
        }

        // int row = matrix.length, col = matrix[0].length;
        // int r[] = new int[row]; // array of size number of rows
        // int c[] = new int[col]; // array of size number of colms
        // for(int i=0; i<row; i++){
        // r[i] = -1;
        // }
        // for(int j=0; j<col; j++){
        // c[j] = -1;
        // }
        // for(int i=0; i<row; i++){
        // for(int j=0; j<col; j++){
        // if(matrix[i][j] == 0){
        // r[i] = 0; c[j] = 0;
        // }
        // }
        // }
        // for(int i=0; i<row; i++){
        // for(int j=0; j<col; j++){
        // if(r[i]==0 || c[j]==0){
        // matrix[i][j] = 0;
        // }
        // }
        // }

    }
}