public class CeilingOfNumber {
    public static void main(String[] args) {
        System.out.println(findCeiling(new int[] { 2, 3, 5, 9, 14, 16, 18 }, 15));
    }

    /**
     * 
     * @param nums
     * @param target
     * @return index of smallest number >= target number
     */
    private static int findCeiling(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (target > nums[nums.length - 1]) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}