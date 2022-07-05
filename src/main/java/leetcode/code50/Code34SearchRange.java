package leetcode.code50;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-07-05 23:31
 * @Description: 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Code34SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (nums.length == 0) return res;
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        if (nums[l] != target) return res;
        res[0] = l;
        l = 0;
        r = nums.length - 1;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }

        res[1] = l;
        return res;
    }
}
