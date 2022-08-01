package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-31 17:21
 * @Description: You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class Code494FindTargetSumWays {
    int t = 0;
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        t = target;
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == t) {
                res++;
            }
            return;
        }

        dfs(nums, index + 1, target + nums[index]);
        dfs(nums, index + 1, target - nums[index]);

    }
}
