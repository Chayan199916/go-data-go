public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {}));
    }

    private static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int correctPos = nums[i];
            if (nums[i] < nums.length && nums[correctPos] != nums[i]) {
                swap(nums, correctPos, i);
            } else {
                i++;
            }
        }
        /**
         * search for first missing number
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        /**
         * case - 2: missing number not present in the array
         */
        return nums.length;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
