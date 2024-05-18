import java.util.Arrays;

public class MinimumOperation_GFG {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.println(minOperation(i));
        }
    }

    private static int minOperation(int n) {
        // code here.
        // return minOperationsToReachN(n);
        return minOperationsToReachNTopDown(n, new Integer[n + 1]);
    }

    /**
     * Bottom up approach
     */
    private static int minOperationsToReachN(int target) {

        // Check if the result is already memoized
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // if even, then needs 1 operation to reach i from i / 2
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1); // if odd, then i - 1 is even; so after reaching i - 1, only one
                                                    // operation to reach i
        }

        return dp[target];
    }

    private static int minOperationsToReachNTopDown(int target, Integer[] memo) {
        // Check if the result is already memoized
        if (memo[target] != null) {
            return memo[target];
        }

        // Base case: If the target is 1, return 1 operation
        if (target <= 1) {
            return target;
        }

        int minOps;

        // Recursive calls for the two possible operations
        if (target % 2 == 0) {
            minOps = Math.min(minOperationsToReachNTopDown(target / 2, memo) + 1,
                    minOperationsToReachNTopDown(target - 1, memo) + 1);
        } else {
            minOps = minOperationsToReachNTopDown(target - 1, memo) + 1;
        }

        // Memoize the result
        memo[target] = minOps;

        return minOps;
    }
}