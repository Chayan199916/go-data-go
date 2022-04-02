import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
    }

    private static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i, resIndex = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
        }
        int firstNonNegative = i;
        int lastNegative = i - 1;
        while (lastNegative >= 0 && firstNonNegative < nums.length) {
            if (nums[lastNegative] * nums[lastNegative] > nums[firstNonNegative] * nums[firstNonNegative]) {
                result[resIndex++] = nums[firstNonNegative] * nums[firstNonNegative];
                firstNonNegative++;
            } else if (nums[lastNegative] * nums[lastNegative] < nums[firstNonNegative] * nums[firstNonNegative]) {
                result[resIndex++] = nums[lastNegative] * nums[lastNegative];
                lastNegative--;
            } else {
                result[resIndex++] = nums[lastNegative] * nums[lastNegative];
                result[resIndex++] = nums[firstNonNegative] * nums[firstNonNegative];
                lastNegative--;
                firstNonNegative++;
            }
        }
        while (lastNegative >= 0) {
            result[resIndex++] = nums[lastNegative] * nums[lastNegative];
            lastNegative--;
        }
        while (firstNonNegative < nums.length) {
            result[resIndex++] = nums[firstNonNegative] * nums[firstNonNegative];
            firstNonNegative++;
        }
        return result;
    }
}