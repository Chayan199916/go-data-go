import java.util.Arrays;

public class TilingProblem {

    // Recursive function to count the number of ways to tile a 2 x N grid
    public static int countWaysToTile(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else {
            // The current tile can be placed either vertically or horizontally.
            // If placed vertically, then the remaining grid is 2 x (N - 1).
            // If placed horizontally, then the remaining grid is 2 x (N - 2).
            return countWaysToTile(N - 1) + countWaysToTile(N - 2);
        }
    }

    /**
     * time : O(n)
     * space : O(n)
     */
    public static int countWaysToTileBottomUp(int n) {
        int[] waysToTile = new int[n + 1];
        waysToTile[1] = 1;
        waysToTile[2] = 2;
        for (int i = 3; i <= n; i++) {
            waysToTile[i] = waysToTile[i - 1] + waysToTile[i - 2];
        }
        return waysToTile[n];
    }

    /**
     * time : O(n)
     * space : O(1)
     */
    public static int countWaysToTileBottomUpV2(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");
        if (n <= 2)
            return n;
        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

    public static int countWaysToTileTopBottom(int n, int[] mem) {
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");
        if (mem[n] != -1)
            return mem[n];
        if (n <= 2)
            return mem[n] = n;
        return mem[n] = countWaysToTileTopBottom(n - 1, mem) + countWaysToTileTopBottom(n - 2, mem);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] mem = new int[N + 1];
        Arrays.fill(mem, -1);
        int ways = countWaysToTileTopBottom(N, mem);
        System.out.println("Number of ways to tile a 2 x " + N + " grid: " + ways);
    }
}
