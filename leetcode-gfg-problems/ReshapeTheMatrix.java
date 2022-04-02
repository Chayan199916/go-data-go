public class ReshapeTheMatrix {
    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat[0].length * mat.length) {
            return mat;
        }
        int ans[][] = new int[r][c];
        int m = 0, n = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = mat[m][n];
                if (n < mat[0].length - 1) {
                    n++;
                } else {
                    m++;
                    n = 0;
                }

            }
        }
        return ans;
    }
}