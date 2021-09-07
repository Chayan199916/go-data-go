class MatrixDiagonalSum {
    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
    }

    private static int diagonalSum(int[][] mat) {
        int sum = 0, j;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == j) {
                    sum += mat[i][j];
                }
                if (i + j == n - 1) {
                    sum += mat[i][j];
                }
            }
        }
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }
}