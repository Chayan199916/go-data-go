import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 */
public class ProductExceptSelf {
    public static int[] calculateProductExceptSelfWOUsingDivision(int[] nums) {
        int[] prefixProductArr = new int[nums.length];
        int[] suffixProductArr = new int[nums.length];
        prefixProductArr[0] = nums[0];
        suffixProductArr[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefixProductArr[i] = nums[i] * prefixProductArr[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProductArr[i] = nums[i] * suffixProductArr[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int suffixProduct = i + 1 == nums.length ? 1 : suffixProductArr[i + 1];
            int prefixProduct = i - 1 == -1 ? 1 : prefixProductArr[i - 1];
            nums[i] = suffixProduct * prefixProduct;
        }
        return nums;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int prefix = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }

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
        System.out.println(Arrays.toString(calculateProductExceptSelfWOUsingDivision(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(calculateProductExceptSelfWOUsingDivision(new int[] { -1, 1, 0, -3, 3 })));
    }
}
