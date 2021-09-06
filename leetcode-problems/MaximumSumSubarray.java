public class MaximumSumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    private static int maxSum(int[] nums) {
        /**
         * Kadane's algorithm
         */
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return maxSum;
    }
}
