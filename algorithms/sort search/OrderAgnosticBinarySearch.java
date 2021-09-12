public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        System.out.println(orderAgnosticBinarySearch(new int[] { 10, 7, 6, 4, 3, 2 }, 3));
    }

    private static int orderAgnosticBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        /**
         * find whether the arrays is in ascending or descending order.
         */
        boolean isAscending = nums[start] < nums[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (isAscending) {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            // System.out.println(start + " " + end);
        }
        return -1;
    }
}
