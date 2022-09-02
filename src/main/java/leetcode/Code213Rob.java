package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-06-25 17:38
 * @Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * <p>
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * <p>
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class Code213Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }

        int max = Math.max(f[n - 1], g[n - 1]);
        f = new int[n + 1];
        g = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }

        max = Math.max(max, (Math.max(f[n], g[n])));
        return max;
    }
}
