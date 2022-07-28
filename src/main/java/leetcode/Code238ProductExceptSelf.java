package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-07-28 23:11
 * @Description: 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Code238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 2];
        int[] res = new int[n];
        pre[0] = 1;
        suf[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }

        for (int i = n; i > 0; i--) {
            suf[i] = nums[i - 1] * suf[i + 1];
        }


        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = suf[i + 2];
            } else if (i == n - 1) {
                res[i] = pre[n - 1];
            } else {
                res[i] = pre[i] * suf[i + 2];
            }

        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int l = 1, r = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= l;
            l *= nums[i];

            res[n - 1 - i] *= r;
            r *= nums[n - 1 - i];
        }

        return res;
    }
}
