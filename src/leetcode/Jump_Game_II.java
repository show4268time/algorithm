package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @author: yaoweihao
 * @date: 2019/3/20
 * @time: 8:45
 * @modified by:
 */
public class Jump_Game_II {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        jump(nums);
    }

    public static int jump(int[] nums) {
        int cur = 0;
        int last = 0;
        int step = 0;
        if (nums.length > 0 && nums[0] > 0) {
            for (int i = 0; i < nums.length && i <= cur; i++) {
                cur = Math.max(cur, i + nums[i]);
                if (i == last) {
                    last = cur;
                    step++;
                    if (cur >= nums.length - 1) break;
                }
            }
        }
        return step;
    }
}
