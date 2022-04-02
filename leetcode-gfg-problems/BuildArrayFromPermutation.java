import java.util.Arrays;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] ans = buildArray(new int[] { 5, 0, 1, 2, 3, 4 });
        System.out.println(Arrays.toString(ans));
    }

    private static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}

// https://leetcode.com/problems/build-array-from-permutation/