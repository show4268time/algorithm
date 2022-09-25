package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-09-25 09:21
 * @Description: Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class Code343IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}
