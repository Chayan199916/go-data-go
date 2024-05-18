import java.util.ArrayList;

public class SearchInRotatedArray_1 {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == k)
                return mid;
            // left part is sorted
            if (arr.get(start) <= arr.get(mid)) {
                // target element lies in this range
                if (k >= arr.get(start) && k <= arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right part is sorted
                // target element lies in this range
                if (k >= arr.get(mid) && k <= arr.get(end)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
