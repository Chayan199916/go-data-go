import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This question was asked by Zillow.
 * 
 * You are given a 2-d matrix where each cell represents number of coins in that
 * cell. Assuming we start at matrix[0][0], and can only move right or down,
 * find the maximum number of coins you can collect by the bottom right corner.
 * 
 * For example, in this matrix
 * 
 * 0 3 1 1
 * 2 0 0 4
 * 1 5 3 1
 * The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 */

public class DCP_1390 {
    static Map<Integer, List<Integer>> getMaxCoinsWithPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int[][] dir = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
            dir[0][j] = 0;
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            dir[i][0] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                    dir[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                    dir[i][j] = 0;
                }
            }
        }
        List<Integer> path = new ArrayList<Integer>();
        int i = rows - 1;
        int j = cols - 1;
        while (i > 0 || j > 0) {
            path.add(matrix[i][j]);
            if (dir[i][j] == 1) {
                i -= 1;
            } else {
                j -= 1;
            }
        }
        path.add(matrix[i][j]);
        Collections.reverse(path);
        Map<Integer, List<Integer>> op = new HashMap<Integer, List<Integer>>();
        op.put(dp[rows - 1][cols - 1], path);
        return op;
    }

    public static void main(String[] args) {
        int[][] coins = {
                { 0, 3, 1, 1 },
                { 2, 0, 0, 4 },
                { 1, 5, 3, 1 }
        };
        System.out.println(getMaxCoinsWithPath(coins));
    }
}