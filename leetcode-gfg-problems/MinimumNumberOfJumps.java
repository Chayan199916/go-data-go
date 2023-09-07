public class MinimumNumberOfJumps {
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            if (farthest <= right) {
                // There's a gap that cannot be crossed.
                return -1; // Or another appropriate indicator for failure.
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}
