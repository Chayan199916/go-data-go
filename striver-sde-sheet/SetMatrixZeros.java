import java.util.ArrayList;

public class SetMatrixZeros {

    public static ArrayList<ArrayList<Integer>> zeroMatrixBetter(ArrayList<ArrayList<Integer>> matrix, Integer n,
            Integer m) {
        // Write your code here.
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    public static ArrayList<ArrayList<Integer>> zeroMatrixOptimal(ArrayList<ArrayList<Integer>> matrix, Integer n,
            Integer m) {
        // Write your code here.
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    if (j > 0) {
                        matrix.get(0).set(j, 0);
                        matrix.get(i).set(0, 0);
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(0).get(j) == 0 || matrix.get(i).get(0) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        if (matrix.get(0).get(0) == 0) {
            for (int j = 1; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
}

/*
 * Given a matrix if an element in the matrix is 0 then you will have to set its
 * entire column and row to 0 and then return the matrix
 */