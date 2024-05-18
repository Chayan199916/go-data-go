import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        // Write your code here.
        int n = permutation.size();
        int i = n - 2;
        int breakpoint = -1;
        for (; i >= 0; i--) {
            // breakpoint found
            if (permutation.get(i) < permutation.get(i + 1)) {
                breakpoint = i;
                break;
            }
        }
        // if no breakpoint exists; sorted in descending order; so next permutation will
        // be the first one in the list
        if (breakpoint == -1) {
            Collections.reverse(permutation);
            return permutation;
        }
        // finding out the closest element to breakpoint element
        int minIndex = n - 1;
        for (; minIndex > breakpoint; minIndex--) {
            if (permutation.get(minIndex) > permutation.get(breakpoint)) {
                int temp = permutation.get(breakpoint);
                permutation.set(breakpoint, permutation.get(minIndex));
                permutation.set(minIndex, temp);
                break;
            }
        }
        // sorted part will become the next permutation; no need to sort; just reverse
        // the sublist
        Collections.reverse(permutation.subList(breakpoint + 1, n));
        return permutation;
    }
}
