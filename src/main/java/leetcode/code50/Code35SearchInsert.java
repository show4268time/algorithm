package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-08-30 23:16
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * <p>
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *    示例 1:  输入: nums = [1,3,5,6], target = 5 输出: 2
 * <p>
 * 示例 2:  输入: nums = [1,3,5,6], target = 2 输出: 1
 * <p>
 * 示例 3:  输入: nums = [1,3,5,6], target = 7 输出: 4  
 */
public class Code35SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums[0] >= target) return 0;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] < target) l = mid;
            else r = mid - 1;
        }
        return l + 1;
    }
}
