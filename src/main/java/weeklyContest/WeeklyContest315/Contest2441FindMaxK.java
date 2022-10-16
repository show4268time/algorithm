package weeklyContest.WeeklyContest315;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-10-16 17:40
 * @Description: Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
 * <p>
 * Return the positive integer k. If there is no such integer, return -1.
 * Example 1:
 * <p>
 * Input: nums = [-1,2,-3,3]
 * Output: 3
 * Explanation: 3 is the only valid k we can find in the array.
 * Example 2:
 * <p>
 * Input: nums = [-1,10,6,7,-7,1]
 * Output: 7
 * Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
 * Example 3:
 * <p>
 * Input: nums = [-10,8,6,7,-2,-3]
 * Output: -1
 * Explanation: There is no a single valid k, we return -1.
 */
public class Contest2441FindMaxK {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) set.add(nums[i]);
            else break;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(-nums[i])) return nums[i];
        }

        return -1;
    }
}
