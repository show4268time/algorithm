package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-19 23:11
 * @Description: 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 */
public class Offer53Search {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        int res = 0;
        for (int i = r; i >= 0; i--) {
            if (nums[i] == target) res++;
            else if (nums[i] < target) break;
        }
        return res;
    }
}
