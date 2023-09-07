import java.util.Arrays;

public class MinimizeTheHeights_1 {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr); // Sort the array to simplify calculations.
        int min_diff = arr[n - 1] - arr[0]; // Initial minimum difference.

        for (int i = 1; i < n; i++) { // creating partitions
            int current_min = Math.min(arr[0] + k, arr[i] - k);
            int current_max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            min_diff = Math.min(min_diff, current_max - current_min);
        }

        return min_diff;
    }
}
