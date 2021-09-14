public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 }));
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                /**
                 * this is possible ans but let's check in the left side.
                 */
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                /**
                 * this is possible ans but let's check in the right side.
                 */
                start = mid + 1;
            }
        }
        return start;
    }
}
