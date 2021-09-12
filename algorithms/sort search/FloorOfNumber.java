public class FloorOfNumber {
    public static void main(String[] args) {
        System.out.println(findFloor(new int[] { 2, 3, 5, 9, 14, 16, 18 }, 14));
    }

    /**
     * 
     * @param nums
     * @param target
     * @return index of greatest element <= target number.
     */
    private static int findFloor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

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
        return end;
    }
}
