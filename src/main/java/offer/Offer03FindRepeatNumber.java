package offer;

/**
 * @author: PhilipFry
 * @create: 2022-08-12 21:18
 * @Description: 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Offer03FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            } else {
                i++;
            }
        }
        return -1;
    }
}
