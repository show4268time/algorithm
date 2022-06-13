package leetcode.code150;

/**
 * @author: PhilipFry
 * @create: 2022-06-12 19:41
 * @Description: You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 */
public class Code122MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i + 1 < prices.length; i++) {
            res = res + Math.max(0, prices[i + 1] - prices[i]);
        }
        return res;
    }
}
