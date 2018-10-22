package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 跳跃游戏
 * 能不能跳到最后一格的问题，转变为：最远能跳到哪里？ 的问题。最后跳得最远的方案，一定是在每一步都选择可以跳得最远的点。
 * 注意！ 问题不是如果选到5就必须一下跳5格。如果是这样，那么最后跳得最远的方案，就未必是每次选择可以跳得最远的点。
 * 看到现在跳5格，但5格后可能下个数字是1。说不定现在跳3格，3格后是100，就赚到了。这样就不符合使用贪心算法的必要条件：最优子结构。
 * 现在这个问题的特点是，比如[5,2,2,3,1,2,3]最开始在5不是说就一定要往后跳5格，而是跳1,2,3,4,5格任选。
 * 所以每一步一定是选可以跳得最远的那个选择，因为代表着接下来有更多的尝试选择。
 * @author: yaoweihao
 * @date: 2018/10/16
 * @time: 10:23
 * @modified by:
 */
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int cursor = 0;
        for (int scope = 0; cursor < nums.length && cursor <= scope; cursor++) {
            scope = Math.max(scope, cursor + nums[cursor]); // greedy
        }
        return cursor == nums.length;
    }
}
