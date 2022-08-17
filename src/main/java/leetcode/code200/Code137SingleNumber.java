package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-08-14 08:53
 * @Description: Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * <p>
 * Find the single element and return it.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 */
public class Code137SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int[] con = new int[32];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int m = nums[i];
            for (int j = 0; j < 32; j++) {
                if (((m >> j) & 1) == 1) {
                    con[j]++;
                }
            }
        }

        for (int i = 0; i < 32; i++) {
            if (con[i] % 3 != 0) {
                res += 1 << i;
            }
        }
        return res;
    }
}
