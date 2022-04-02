// https://leetcode.com/problems/richest-customer-wealth/

public class RichestCustomerWealth {
    public static void main(String[] args) {
        System.out.println(maxWealth(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));
    }

    private static int maxWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int wealth, j;
        for (int i = 0; i < accounts.length; i++) {
            wealth = 0;
            for (j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            if (wealth > max) {
                max = wealth;
            }
        }
        return max;
    }
}
