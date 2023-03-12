import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {
    public static int calculate(int[] nums) {
        int longestLength = 0;
        if (nums.length == 0)
            return 0;
        HashMap<Integer, HashSet<Integer>> sequence = new HashMap<Integer, HashSet<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for (Integer num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                sequence.put(num, new HashSet<Integer>());
            }
        }
        for (Integer key : sequence.keySet()) {
            int seqElement = key.intValue() + 1;
            while (set.contains(seqElement)) {
                sequence.get(key).add(seqElement);
                seqElement++;
            }
            longestLength = Math.max(longestLength, sequence.get(key).size());
        }
        return longestLength + 1;
    }

    public static void main(String[] args) {
        System.out.println(calculate(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(calculate(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
    }
}
