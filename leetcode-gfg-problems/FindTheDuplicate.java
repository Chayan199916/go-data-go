public class FindTheDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 2, 2, 4 }));
    }

    private static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int correct = nums[i] - 1;
            if (nums[correct] != nums[i]) {
                swap(nums, correct, i);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
