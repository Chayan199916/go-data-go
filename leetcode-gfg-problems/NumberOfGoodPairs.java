import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[] { 1, 2, 3, 4 }));
    }

    private static int numIdenticalPairs(int[] nums) {
        int totalNo = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                totalNo += map.get(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return totalNo;
    }
}

// https://leetcode.com/problems/number-of-good-pairs/