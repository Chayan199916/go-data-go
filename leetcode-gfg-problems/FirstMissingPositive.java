import java.util.Arrays;

class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
    }

    private static int firstMissingPositive(int[] nums) {
        // int firstPositive = 1;
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == firstPositive) {
        // firstPositive++;
        // }
        // }
        // return firstPositive;

        for (int i = 0; i < nums.length;) {
            int correctPos = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[correctPos] != nums[i]) {
                swap(nums, correctPos, i);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}