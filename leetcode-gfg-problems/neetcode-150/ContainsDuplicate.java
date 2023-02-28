import java.util.HashMap;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    private static int[] nums;

    public ContainsDuplicate(int[] nums) {
        this.nums = nums;
    }

    boolean checkDuplicate() {
        boolean result = false;
        HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (!frequencies.containsKey(num)) {
                frequencies.put(num, 1);
            } else {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainsDuplicate con = new ContainsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 });
        System.out.println(con.checkDuplicate());
    }
}