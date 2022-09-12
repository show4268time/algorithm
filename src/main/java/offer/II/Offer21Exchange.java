package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-12 18:02
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Offer21Exchange {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int l = -1, r = nums.length;
        while (l < r) {
            do {
                l++;
            } while (l < nums.length && nums[l] % 2 == 1);
            do {
                r--;
            } while (r >= 0 && nums[r] % 2 == 0);
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }
}
