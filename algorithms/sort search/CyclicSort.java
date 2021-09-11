import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 5, 2, 1, 4 };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int correctPos = nums[i] - 1;
            if (nums[correctPos] != nums[i]) {
                swap(nums, correctPos, i);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

/**
 * 
 * complexity : N - 1 + N (total swaps in worst case)
 */