import java.util.Arrays;

public class MergeSortedArrayWithoutExtraSpace {
    /**
     * O(n + m)
     */
    public static void merge(long arr1[], long arr2[], int n, int m) {
        // code here
        int i = 0, j = 0, k = n - 1;

        while (i <= k && j < m) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                long temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;
                j++;
                k--;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    /*
     * O(n * m)
     */
    public static void mergeV2(long arr1[], long arr2[], int n, int m) {
        // code here
        for (int i = m - 1; i >= 0; i--) {
            int j;
            long last = arr1[n - 1];
            for (j = n - 2; j >= 0 && arr1[j] >= arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            /**
             * First part checks whether we didn't reach the end of the arr1 while shifting
             * elements in the inner loop. If this condition is true, it means we have found
             * a position to insert the element from arr2.
             * 
             * Second part checks whether the last element from arr1 is greater than the
             * current element
             * from arr2. If this condition is true, it also indicates that we need to
             * insert the element from arr2
             */
            if (j != n - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
