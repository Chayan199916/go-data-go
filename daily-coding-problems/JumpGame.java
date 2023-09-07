import java.util.Arrays;

/**
 * Given an array of N integers arr[] where each element represents the maximum
 * length of the jump that can be made forward from that element. This means if
 * arr[i] = x, then we can jump any distance y such that y ≤ x.
 * Find the minimum number of jumps to reach the end of the array (starting from
 * the first element). If an element is 0, then you cannot move through that
 * element.
 * 
 * Note: Return -1 if you can't reach the end of the array.
 */
public class JumpGame {
    /**
     * Jump Game I : greedy solution ;
     * tc : O(n)
     * sc : O(1)
     */
    public boolean canJumpGreedy(int[] nums) {
        int currentGoal = nums.length - 1;
        int i = nums.length - 1;
        for (; i >= 0; i--) {
            if (i + nums[i] >= currentGoal) {
                currentGoal = i;
            }
        }
        return currentGoal == 0;
    }

    /**
     * tc : O(M^N) ~ exponential; M = max possible ways; N = number of elements
     * sc : O(N)
     */
    public boolean canJumpFromPositionBruteForce(int[] nums, int position) {
        // Base case: If the current position is the last index, return true.
        if (position == nums.length - 1) {
            return true;
        }

        // Calculate the maximum jump from the current position.
        int maxJump = Math.min(position + nums[position], nums.length - 1);

        // Try all possible jumps from the current position.
        for (int nextPosition = position + 1; nextPosition <= maxJump; nextPosition++) {
            // Recursively check if you can reach the last index from the next position.
            if (canJumpFromPositionBruteForce(nums, nextPosition)) {
                return true;
            }
        }

        // If no jump leads to the last index, return false.
        return false;
    }

    /**
     * tc : O(n*n) -> for each index, I can have at max N jumps, hence O(N* N).
     * sc : O(N) + O(N) -> stack space plus dp array size.
     */
    public boolean canJumpMemoization(int[] nums) {
        int[] dp = new int[nums.length];
        // Initialize all elements in memo to false.
        Arrays.fill(dp, -1);

        return canJumpFromPositionMemoization(nums, 0, dp);
    }

    public boolean canJumpFromPositionMemoization(int[] nums, int position, int dp[]) {
        // Base case: If the current position is the last index, return true.
        if (position == nums.length - 1)
            return true;
        if (nums[position] == 0)
            return false;
        if (dp[position] != -1)
            return dp[position] == 1; // overlapping subproblems

        // Calculate the maximum jump from the current position.
        int maxJump = Math.min(position + nums[position], nums.length - 1);

        // Try all possible jumps from the current position.
        for (int nextPosition = position + 1; nextPosition <= maxJump; nextPosition++) {
            // Recursively check if you can reach the last index from the next position.
            if (canJumpFromPositionMemoization(nums, nextPosition, dp)) {
                dp[position] = 1;
                return true;
            }
        }

        // If no jump leads to the last index, return false.
        dp[position] = 0;
        return false;
    }

    /*
     * tc : O(N* N)
     * sc : O(N) -> dp array size
     */
    public boolean canJumpTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1; // Base case

        for (int idx = n - 2; idx >= 0; idx--) {
            if (nums[idx] == 0) {
                dp[idx] = 0;
                continue;
            }

            int flag = 0;
            int reach = Math.min(idx + nums[idx], nums.length - 1);
            for (int jump = idx + 1; jump <= reach; jump++) {
                if (dp[jump] == 1) {
                    dp[idx] = 1;
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                continue;
            }

            dp[idx] = 0;
        }

        return dp[0] == 1;
    }
}
