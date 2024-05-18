import java.util.ArrayList;

public class PascalTriangle {
    public static int findNCR(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static ArrayList<Integer> findNthRow(int n) {
        ArrayList<Integer> nthRow = new ArrayList<Integer>();
        for (int c = 1; c <= n; c++) {
            nthRow.add(findNCR(n - 1, c - 1));
        }
        return nthRow;
    }

    public static ArrayList<Integer> findNthRowOptimal(int n) {
        ArrayList<Integer> nthRow = new ArrayList<Integer>();
        int ans = 1;
        nthRow.add(ans);
        for (int c = 1; c < n; c++) {
            ans = ans * (n - c);
            ans = ans / c;
            nthRow.add(ans);
        }
        return nthRow;
    }

    public static int[][] pascalTriangle(int N) {
        // Write your code here.
        int[][] pT = new int[N][];
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<ArrayList<Integer>>();
        for (int row = 1; row <= N; row++) {
            pascalTriangle.add(findNthRow(row));
        }
        for (int i = 0; i < pT.length; i++) {
            ArrayList<Integer> nthRow = pascalTriangle.get(i);
            pT[i] = new int[nthRow.size()];
            for (int j = 0; j < nthRow.size(); j++) {
                pT[i][j] = nthRow.get(j);
            }
        }
        return pT;
    }
}
