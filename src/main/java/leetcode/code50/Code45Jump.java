package leetcode.code50;

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
}
