package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-06-30 23:12
 * @Description: Given an integer array nums of size n,
 * return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment or decrement an element of the array by 1.
 * <p>
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 */
public class Code462MinMoves2 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int e = nums[n / 2];
        for (int i = 0; i < n; i++) {
            count += Math.abs(nums[i] - e);
        }
        return count;
    }
}
