package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-07-08 23:22
 * @Description: 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 */
public class Code55CanJump {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (i > max) return false;
            max = Math.max(i + nums[i], max);
            if (max >= n - 1) return true;
        }
        return max >= n - 1;
    }
}
