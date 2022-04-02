import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        List<Integer> result = countSmaller(new int[] { 5, 2, 6, 1 });
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> countSmaller(int[] nums) {
        int j;
        List<Integer> result = new ArrayList<Integer>(Collections.nCopies(nums.length, 0));
        for (int i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    result.set(i, result.get(i) + 1);
                }
            }
        }
        return result;
    }
}

/** time limit exceeded; will come back again */
