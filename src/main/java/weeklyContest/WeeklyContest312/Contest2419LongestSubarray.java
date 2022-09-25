package weeklyContest.WeeklyContest312;

/**
 * @author: PhilipFry
 * @create: 2022-09-25 15:18
 * @Description: You are given an integer array nums of size n.
 * <p>
 * Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
 * <p>
 * In other words, let k be the maximum value of the bitwise AND of any subarray of nums.
 * <p>
 * Then, only subarrays with a bitwise AND equal to k should be considered.
 * Return the length of the longest such subarray.
 * <p>
 * The bitwise AND of an array is the bitwise AND of all the numbers in it.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,3,2,2]
 * Output: 2
 * Explanation:
 * The maximum possible bitwise AND of a subarray is 3.
 * The longest subarray with that value is [3,3], so we return 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 1
 * Explanation:
 * The maximum possible bitwise AND of a subarray is 4.
 * The longest subarray with that value is [4], so we return 1.
 */
public class Contest2419LongestSubarray {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                if (l == -1 && r == -1) {
                    l = i;
                    r = i;
                }
                r = i;
                res = Math.max(res, r - l + 1);
            } else {
                l = -1;
                r = -1;
            }

        }
        return res;
    }
}
