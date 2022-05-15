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

}
