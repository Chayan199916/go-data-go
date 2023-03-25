/**
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * Your solution must use only constant extra space.
 */

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1;
            int end = numbers.length - 1;
            int searchKey = target - numbers[i];
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (searchKey == numbers[mid]) {
                    return new int[] { i + 1, mid + 1 };
                } else if (searchKey < numbers[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public int[] twoSumII(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a, num_b;

        while (a_pointer < b_pointer) {
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];

            if (num_a + num_b == target)
                break;

            if (num_a + num_b < target) {
                a_pointer++;
                continue;
            }

            b_pointer--;
        }

        return new int[] { a_pointer + 1, b_pointer + 1 };
    }
}
