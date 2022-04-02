public class SetMismatch {
    public static void main(String[] args) {

    }

    private static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
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
                result[0] = nums[i];
                result[1] = i + 1;
            }
        }
        return result;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
