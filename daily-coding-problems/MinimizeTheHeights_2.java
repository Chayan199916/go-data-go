import java.util.Arrays;

public class MinimizeTheHeights_2 {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        // int min_diff = Integer.MAX_VALUE;

        // // Generate all possible combinations of increasing and decreasing heights
        // int[] operations = {-k, k};
        // int[] combination = new int[n];

        // // Iterate through all combinations
        // for (int i = 0; i < Math.pow(2, n); i++) {
        // for (int j = 0; j < n; j++) {
        // combination[j] = arr[j] + operations[(i >> j) & 1];
        // }

        // int max_height = Arrays.stream(combination).max().getAsInt();
        // int min_height = Arrays.stream(combination).min().getAsInt();
        // int current_diff = max_height - min_height;
        // min_diff = Math.min(min_diff, current_diff);
        // }
        // return min_diff;

        // return generateCombinations(arr, n, k, 0, Integer.MAX_VALUE);

        // O(n) solution
        Arrays.sort(arr); // Sort the array to simplify calculations.
        int min_diff = arr[n - 1] - arr[0]; // Initial minimum difference.

        for (int i = 1; i < n; i++) { // creating partitions
            int current_min = Math.min(arr[0] + k, arr[i] - k);
            int current_max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            if (current_min < 0)
                continue;
            min_diff = Math.min(min_diff, current_max - current_min);
        }

        return min_diff;
    }
    // int generateCombinations(int[] arr, int N, int K, int index, int min_diff) {
    // // Base case: All towers have been processed.
    // if (index == N) {
    // // Calculate the height difference.
    // int max_height = Arrays.stream(arr).max().getAsInt();
    // int min_height = Arrays.stream(arr).min().getAsInt();
    // return max_height - min_height;
    // }

    // // Calculate the height difference without modifying the current tower.
    // // int withoutModification = generateCombinations(arr, N, K, index + 1,
    // min_diff);

    // // Calculate the height difference by increasing the current tower's height.
    // arr[index] += K;
    // int afterIncrease = generateCombinations(arr, N, K, index + 1, min_diff);
    // arr[index] -= K; // Revert the change.

    // // Calculate the height difference by decreasing the current tower's height.
    // arr[index] -= K;
    // int afterDecrease = generateCombinations(arr, N, K, index + 1, min_diff);
    // arr[index] += K; // Revert the change.

    // // Update the minimum height difference found so far.
    // min_diff = Math.min(min_diff, Math.min(afterIncrease, afterDecrease));

    // return min_diff;
    // }
}