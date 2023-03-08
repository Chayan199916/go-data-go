import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 */
public class ProductExceptSelf {
    public static int[] calculateProductExceptSelfUsingDivision(int[] nums) {
        int productOfNums = 1;
        boolean zeroFlag = false;
        for (int num : nums) {
            if (num == 0) {
                zeroFlag = true;
            } else {
                productOfNums *= num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? productOfNums : zeroFlag ? 0 : productOfNums / nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateProductExceptSelfUsingDivision(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(calculateProductExceptSelfUsingDivision(new int[] { -1, 1, 0, -3, 3 })));
    }
}
