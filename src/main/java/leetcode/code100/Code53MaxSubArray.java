package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-06-14 23:34
 * @Description: Given an integer array nums, find the contiguous (邻接) subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous (邻接) part of an array.
 */
public class Code53MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
