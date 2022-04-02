public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { -2, 0, -1 }));
    }

    private static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int tempMaxProduct, tempMinProduct;
        int res = nums[0];
        int current;
        for (int i = 1; i < nums.length; i++) {
            current = nums[i];
            if (current == 0) {
                maxProduct = 1;
                minProduct = 1;
            }
            tempMaxProduct = current * maxProduct;
            tempMinProduct = current * minProduct;
            maxProduct = Math.max(Math.max(tempMaxProduct, tempMinProduct), current);
            minProduct = Math.min(Math.min(tempMinProduct, tempMaxProduct), current);
            res = Math.max(res, maxProduct);
        }
        return res;
    }
}
