import java.util.Arrays;

class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 5, 1, 5, 8, 9, 5, 7, 4, 6, 3, 5 };
        getThreeWayPartition(nums, 5);
        System.out.println(Arrays.toString(nums));
    }

    public static void getThreeWayPartition(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int k = n - 1;
        while (j <= k) {
            if (nums[j] < target) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] > target) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}