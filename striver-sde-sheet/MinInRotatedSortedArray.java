public class MinInRotatedSortedArray {
    public static int findMin(int[] arr) {
        // Write your code here.
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[start] <= arr[mid]) {
                min = Math.min(min, arr[start]);
                start = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}
