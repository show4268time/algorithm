package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-26 10:17
 * @Description: Given a set of distinct positive integers nums,
 * return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 * <p>
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 */
public class Code368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > result) {
                        result = dp[i];
                        k = i;
                    }
                }
            }
        }
        res.add(nums[k]);
        while (dp[k] > 1) {
            for (int i = k - 1; i >= 0; i--) {
                if (nums[k] % nums[i] == 0 && dp[k] == dp[i] + 1) {
                    res.add(nums[i]);
                    k = i;
                    break;
                }
            }
        }
        return res;
    }
}
