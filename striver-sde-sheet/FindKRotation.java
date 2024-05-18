public class FindKRotation {
    public static int findKRotation(int[] arr) {
        // Write your code here.
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[start] <= arr[mid]) {
                if (arr[start] < min) {
                    min = arr[start];
                    minIndex = start;
                }
                start = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    minIndex = mid;
                }
                end = mid - 1;
            }
        }
        return minIndex;
    }
}
