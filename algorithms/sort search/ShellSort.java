import java.util.Arrays;

public class ShellSort {
    private static void getSortedArray(int[] nums) {
        int size = nums.length;

        // Start with a big gap, then reduce the gap
        for (int gap = size / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements nums[0..gap-1] are already in gapped order.
            // Keep adding one more element until the entire array is gap sorted.
            for (int i = gap; i < size; i++) {
                // Add nums[i] to the elements that have been gap sorted
                // Save nums[i] in temp and make a hole at position i

                // Shift earlier gap-sorted elements up until the correct location for nums[i]
                // is found
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (nums[j] < nums[j + gap]) {
                        break;
                    } else {
                        int temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        getSortedArray(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
    }
}
