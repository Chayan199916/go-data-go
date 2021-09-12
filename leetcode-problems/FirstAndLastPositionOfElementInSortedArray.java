import java.util.Arrays;

class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 2, 3, 7, 7, 7, 7, 9 }, 7)));
    }

    private static int[] searchRange(int[] nums, int target) {
        /**
         * We are going to apply binary search twice. first time to get the first
         * position of the target element and next time to get the last position of the
         * target element.
         * 
         */
        int[] ans = new int[] { -1, -1 };
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    private static int search(int[] nums, int target, boolean isStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // potential ans found
                ans = mid;
                /**
                 * we are checking whether this is the first index or there exist more left to
                 * this one.
                 */
                if (isStartIndex) {
                    end = mid - 1;
                }
                /**
                 * we are checking whether this is the last index or there exist more right to
                 * this one.
                 */
                else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
