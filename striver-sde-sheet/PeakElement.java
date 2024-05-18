import java.util.ArrayList;

public class PeakElement {
    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.
        int n = arr.size();
        if (n == 1)
            return arr.get(0);
        if (arr.get(0) > arr.get(1))
            return 0;
        if (arr.get(n - 1) > arr.get(n - 2))
            return n - 1;
        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1))
                return mid;
            else if (arr.get(mid) > arr.get(mid - 1)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
