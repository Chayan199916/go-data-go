import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 4, 3, 2, 1 };
        shuffle2(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int i, j = 0, k = n;
        for (i = 0; i < 2 * n; i += 2) {
            ans[i] = nums[j++];
            ans[i + 1] = nums[k++];
        }
        return ans;
    }

    private static void shuffle2(int[] nums, int n) {
        final int len = nums.length;

        int i;
        // to store the pair of numbers in right half of the original array
        for (i = n; i < len; i++)
            nums[i] = (nums[i] * 1024) + nums[i - n];

        int index = 0;
        // to retrive values from the pair of numbers and placing those retrieved value
        // at their desired position
        for (i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1024;
            nums[index + 1] = nums[i] / 1024;
        }
    }
}