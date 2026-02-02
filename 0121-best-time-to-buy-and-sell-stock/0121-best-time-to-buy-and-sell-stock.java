class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // track lowest price so far
        int maxProfit = 0;                // track maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update lowest price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // update max profit
            }
        }

        return maxProfit;
    }
}