package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-07-07 11:51
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Code42Trap {
    public int trap(int[] height) {
        int n = height.length;
        int[][] dp = new int[n][2];

        dp[0][0] = height[0];
        dp[n - 1][1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(height[i], dp[i - 1][0]);
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[i][1] = Math.max(height[i], dp[i + 1][1]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return res;
    }
}
