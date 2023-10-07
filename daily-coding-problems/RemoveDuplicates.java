public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        /*
         * Intuition: We can think of using two pointers ‘i’ and ‘j’, we move ‘j’ till
         * we don’t get a number arr[j] which is different from arr[i]. As we got a
         * unique number we will increase the i pointer and update its value by arr[j].
         */
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public int removeDuplicatesII(int[] nums) {
        int left = 0;
        int count = 1; // Initialize a count for the current element.

        for (int right = 1; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
                if (count < 2) {
                    left++;
                    nums[left] = nums[right];
                }
                count++;
            } else {
                left++;
                nums[left] = nums[right];
                count = 1; // Reset the count for the new element.
            }
        }
        return left + 1;
    }
}
