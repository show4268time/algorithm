package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-23 16:32
 * @Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * <p>
 * 并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 */
public class Code152MaxProduct {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int f = res, g = res;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int fn = f * n;
            int gn = g * n;
            f = Math.max(n, Math.max(fn, gn));
            g = Math.min(n, Math.min(fn, gn));
            res = Math.max(f, res);
        }
        return res;
    }
}
