import java.util.List;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        List<Integer> result = findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });
        for (Integer element : result) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length;) {
            int correct = nums[i] - 1;
            if (nums[correct] != nums[i]) {
                swap(nums, correct, i);
            } else {
                i++;
            }
        }
        // System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
