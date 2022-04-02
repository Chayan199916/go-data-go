import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] ans = getConcatenation(new int[] { 1, 2, 1 });
        System.out.println(Arrays.toString(ans));
    }

    private static int[] getConcatenation(int[] nums) {
        // String str = Arrays.toString(nums);
        // str = str.substring(0, str.length() - 1) + ", " + str.substring(1);
        // int[] result = Arrays.stream(str.substring(1, str.length() -
        // 1).split(",")).map(String::trim)
        // .mapToInt(Integer::parseInt).toArray();
        // return result;
        int[] ans = new int[2 * nums.length];
        int i;
        for (i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[nums.length + i] = nums[i];
        }
        return ans;
    }
}

// https://leetcode.com/problems/concatenation-of-array/