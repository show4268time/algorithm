package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-10 19:57
 * @Description: You are given an integer array coins representing coins of different denominations and
 * an integer amount representing a total amount of money.  Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Code322CoinChange {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], 0x3f3f3f3f);
        dp[0][0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coin <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[coins.length][amount] == 0x3f3f3f3f ? -1 : dp[coins.length][amount];
    }


    private int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = dp(coins, amount - coin);
            if (count < 0) {
                continue;
            }
            res = Math.min(res, count + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[0], 0x3f3f3f3f);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int x = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * x <= j; k++) {
                    if (dp[i - 1][j - k * x] != 0x3f3f3f3f) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * x] + k);
                    }
                }
            }
        }
        return dp[n][amount] == 0x3f3f3f3f ? -1 : dp[n][amount];
    }


    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int x = coins[i];
            for (int j = x; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }

}
