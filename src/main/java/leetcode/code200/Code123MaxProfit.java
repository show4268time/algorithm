package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-07-25 23:58
 * @Description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Code123MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - min);
        }
        int res = 0;
        int max = 0;
        for (int i = n; i > 0; i--) {
            max = Math.max(prices[i - 1], max);
            int p = Math.max(0, max - prices[i - 1]);
            res = Math.max(dp[i - 1] + p, res);
        }
        return res;
    }
}
