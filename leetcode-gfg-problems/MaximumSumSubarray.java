public class MaximumSumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    private static long maxSum(int[] nums) {
        /**
         * Kadane's algorithm
         */
        long currentMax = nums[0];
        long globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}
