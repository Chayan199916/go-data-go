import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int positiveClosestTarget = Integer.MAX_VALUE;
        int negativeClosestTarget = Integer.MIN_VALUE + 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    positiveClosestTarget = target;
                    negativeClosestTarget = target;
                    break;
                } else if (sum > target) {
                    positiveClosestTarget = Math.min(positiveClosestTarget, sum);
                    k--;
                } else if (sum < target) {
                    negativeClosestTarget = Math.max(negativeClosestTarget, sum);
                    j++;
                }
            }
        }
        return Math.abs(positiveClosestTarget - target) > Math.abs(target - negativeClosestTarget)
                ? negativeClosestTarget
                : positiveClosestTarget;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] { 0, 1, 2 }, 0));
    }
}
