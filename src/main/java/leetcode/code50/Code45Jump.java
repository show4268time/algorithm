package leetcode.code50;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-28 17:12
 * @Description: Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 */
public class Code45Jump {
    int min = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        dp(nums, 0, 0);
        return min;
    }

    public int jump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int cur = 0, dis = 0, next = 0;
        int res = 0;
        while (dis < n - 1) {
            next = 0;
            while (cur <= dis) {
                next = Math.max(next, nums[cur] + cur);
                cur++;
            }
            res++;
            dis = next;
        }
        return res;
    }

    private void dp(int[] nums, int i, int count) {
        if (i >= nums.length - 1) {
            min = Math.min(min, count);
            return;
        }

        count++;

        for (int j = 1; j <= nums[i]; j++) {
            dp(nums, i + j, count);
        }
    }

    public int jump3(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int dis = 0;
        int nextDis = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            nextDis = Math.max(i + nums[i], nextDis);
            if (i == dis) {
                if (dis != n - 1) {
                    dis = nextDis;
                    res++;
                    if (dis >= n - 1) {
                        return res;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
