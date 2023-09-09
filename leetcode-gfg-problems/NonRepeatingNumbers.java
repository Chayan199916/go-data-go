public class NonRepeatingNumbers {
    public int[] singleNumber(int[] nums) {
        // Code here
        int xorResult = 0;

        // Calculate XOR of all elements in nums
        for (int num : nums) {
            xorResult ^= num;
        }

        // Find the rightmost set bit
        int rightmostSetBit = 1;
        while ((rightmostSetBit & xorResult) == 0) {
            rightmostSetBit <<= 1;
        }

        // Initialize variables to store the two distinct numbers
        int distinct1 = 0;
        int distinct2 = 0;

        // Separate the numbers based on the rightmost set bit
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                distinct1 ^= num;
            } else {
                distinct2 ^= num;
            }
        }

        // Return the distinct numbers in increasing order
        return new int[] { Math.min(distinct1, distinct2), Math.max(distinct1, distinct2) };
    }
}
