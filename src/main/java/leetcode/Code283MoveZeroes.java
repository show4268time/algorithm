package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-29 23:01
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Code283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if (nums[fast] == 0) continue;

            nums[slow] = nums[fast];
            slow++;
        }

        for (; slow < n; slow++) {
            nums[slow] = 0;
        }
    }
}
