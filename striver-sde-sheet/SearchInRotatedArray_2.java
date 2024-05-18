public class SearchInRotatedArray_2 {
    public static boolean searchInARotatedSortedArrayII(int[] A, int key) {
        // Write your code here.
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == key)
                return true;
            /*
             * shrinking the search space from both ends.
             * if there are many duplicates then it might take upto O(n / 2)
             * as very less space will remain for binary search
             */
            if (A[start] == A[mid] && A[mid] == A[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }
            if (A[start] <= A[mid]) {
                if (key >= A[start] && key <= A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key >= A[mid] && key <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
