import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        int[][] mat = new int[][] { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 1 } };
        int[][] target = new int[][] { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 1 } };
        System.out.println(findRotation(mat, target));
    }

    private static boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (checkSimilarity(mat, target)) {
                return true;
            }
            colReverse(mat);
            transpose(mat);
        }
        return false;
    }

    private static boolean checkSimilarity(int[][] a, int[][] b) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; ++i) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }

        return true;
    }

    // private static void rowReverse(int[][] mat) {
    // for (int i = 0; i < mat.length; i++) {
    // int left = 0;
    // int right = mat[i].length - 1;
    // while (left < right) {
    // int temp = mat[left][i];
    // mat[left][i] = mat[right][i];
    // mat[right][i] = temp;
    // left++;
    // right--;
    // }
    // }
    // }

    private static void colReverse(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int top = 0;
            int bottom = mat[i].length - 1;
            while (top < bottom) {
                int temp = mat[top][i];
                mat[top][i] = mat[bottom][i];
                mat[bottom][i] = temp;
                top++;
                bottom--;
            }
        }
    }

    private static void transpose(int[][] mat) {
        int temp;
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[i].length; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}
