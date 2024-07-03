package by.andd3dfx.dynamic;

/**
 * <pre>
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/">Task description</a>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * </pre>
 *
 * @see <a href="https://youtu.be/XYPIKrEBbCc">Video solution</a>
 */
public class BestTimeToBuyNSellStock {

    public int maxProfit_ON2(int[] prices) {
        var maxProfit = 0;
        for (int indexToBuy = 0; indexToBuy < prices.length - 1; indexToBuy++) {
            for (int indexToSell = indexToBuy + 1; indexToSell < prices.length; indexToSell++) {
                var profit = prices[indexToSell] - prices[indexToBuy];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit_ON(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
