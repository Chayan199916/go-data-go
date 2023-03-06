import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 */
public class TwoSum {
    private int[] nums;

    public TwoSum(int[] nums) {
        this.nums = nums;
    }

    public int[] getPair(int target) {
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            if (!sumMap.containsKey(nums[index])) {
                sumMap.put(target - nums[index], index);
            } else {
                return new int[] { sumMap.get(nums[index]), index };
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum(new int[] { 2, 7, 11, 15 });
        System.out.println(Arrays.toString(twoSum.getPair(9)));
    }
}
