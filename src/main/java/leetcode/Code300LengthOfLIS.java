package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-10 18:09
 * @Description: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
public class Code300LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] q = new int[nums.length];
        Arrays.fill(q, Integer.MAX_VALUE);
        int result = 0;
        for(int i = 0; i< nums.length; i++){
            int n = nums[i];
            int k = nums.length;
            while(k > 0 && q[k -1] >= n){
                k--;
            }
            result = Math.max(result, k + 1);
        }
        return result;
    }
}
