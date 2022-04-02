public class MaximumSumSubArrayOfSizeK {

    static int calculateSum(int[] numbers, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++)
            sum += numbers[i];
        if (sum > max)
            max = sum;
        for (int i = k; i < numbers.length; i++) {
            sum += numbers[i];
            sum -= numbers[i - k];
            if (sum > max)
                max = sum;
        }
        return max;
    }

    static int calculateSum2(int[] numbers, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        while (end < numbers.length) {
            sum += numbers[end];
            if (end - start + 1 < k) {
                end++;
            } else if (end - start + 1 == k) {
                max = Math.max(max, sum);
                sum -= numbers[start++];
                end++;
            }
        }
        return max;
    }
}