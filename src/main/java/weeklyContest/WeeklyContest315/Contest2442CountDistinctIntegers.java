package weeklyContest.WeeklyContest315;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-10-16 17:41
 * @Description: You are given an array nums consisting of positive integers.
 * <p>
 * You have to take each integer in the array, reverse its digits, and add it to the end of the array. You should apply this operation to the original integers in nums.
 * <p>
 * Return the number of distinct integers in the final array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,13,10,12,31]
 * Output: 6
 * Explanation: After including the reverse of each number, the resulting array is [1,13,10,12,31,1,31,1,21,13].
 * The reversed integers that were added to the end of the array are underlined. Note that for the integer 10, after reversing it, it becomes 01 which is just 1.
 * The number of distinct integers in this array is 6 (The numbers 1, 10, 12, 13, 21, and 31).
 * Example 2:
 * <p>
 * Input: nums = [2,2,2]
 * Output: 1
 * Explanation: After including the reverse of each number, the resulting array is [2,2,2,2,2,2].
 * The number of distinct integers in this array is 1 (The number 2).
 */
public class Contest2442CountDistinctIntegers {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }

    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            int m = n % 10;
            res = res * 10 + m;
            n /= 10;
        }
        return res;
    }
}
