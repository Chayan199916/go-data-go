public class FindTheDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 2, 2, 4 }));
    }

    private static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int correct = nums[i] - 1;
            if (nums[correct] != nums[i]) {
                swap(nums, correct, i);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    /*
     * The following 2 conditions must hold:
     * 
     * 1) i = m + p * n + k
     * 
     * 2) 2i = m + q * n + k
     * The first one says that the tortoise moves i steps and in these i steps, it
     * first gets to the cycle. Then it goes through the cycle p times for some
     * positive number p. Finally, it goes over k more nodes until it meets hare.
     * 
     * A similar thing is true for hare. It moves 2i steps and in these 2i steps it
     * first gets to the cycle. Then it goes through the cycle q times for some
     * positive number q. Finally, it goes over k more nodes until it meets the
     * tortoise.
     * 
     * As the hare travels with double the speed of the tortoise, and time is
     * constant for both when they reach the meeting point.
     * 
     * So by using simple speed, time and distance relation,
     * 
     * 2 ( m + p * n + k ) = m + q * n + k
     * 
     * => 2m + 2pn + 2k = m + nq + k
     * 
     * => m + k = ( q - 2p ) n
     */
    public int findDuplicateTortoiseHare(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        // Phase 1: Find the intersection point in the cycle
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Find the entrance to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        // The tortoise and hare have met at the entrance to the cycle
        return tortoise;
    }
}
