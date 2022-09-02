package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-06-25 17:36
 * @Description: You are a professional robber planning to rob houses along a street.
 * <p>
 * Each house has a certain amount of money stashed,
 * <p>
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * <p>
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * <p>
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output:
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class Code198Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(f[n], g[n]);
    }
}
