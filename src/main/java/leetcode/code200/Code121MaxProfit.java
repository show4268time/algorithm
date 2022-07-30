package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-06-12 15:47
 * @Description: You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Code121MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
