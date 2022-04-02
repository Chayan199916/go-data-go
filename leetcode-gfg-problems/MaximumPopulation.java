import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

class MaximumPopulation {
    private static int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        for (int i = 0; i < logs.length; i++) {
            for (int s = logs[i][0]; s < logs[i][1]; s++) {
                arr[s - 1950]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 101; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return max + 1950;
    }
}