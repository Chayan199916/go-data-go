import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] res = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                x = i;
                y = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] { x, y };
    }
}
