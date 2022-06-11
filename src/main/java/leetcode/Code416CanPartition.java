package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-06-11 15:30
 * @Description: Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets  is equal.
 */
public class Code416CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 > 0) return false;
        sum = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int t = nums[i - 1];
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= t) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - t];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 > 0) return false;
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int t = nums[i - 1];
            for (int j = sum; j >= t; j--) {
                dp[j] = dp[j] || dp[j - t];
            }
        }
        return dp[sum];
    }
}
