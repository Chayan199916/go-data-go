public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(calcProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(calcProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    static int calcProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;
        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            profit = Math.max(profit, prices[right] - prices[left]);
            right = right + 1;
        }
        return profit;
    }
}
