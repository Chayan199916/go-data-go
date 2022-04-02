import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(Arrays.toString(result));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prefProd = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefProd;
            prefProd *= nums[i];
        }
        int suffProd = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= suffProd;
            suffProd *= nums[i];
        }
        return ans;
    }
}
