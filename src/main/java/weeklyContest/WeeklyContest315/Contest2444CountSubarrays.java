package weeklyContest.WeeklyContest315;

/**
 * @author: PhilipFry
 * @create: 2022-10-16 17:58
 * @Description: You are given an integer array nums and two integers minK and maxK.
 * <p>
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * <p>
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 */
public class Contest2444CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, index = -1;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == minK) minI = i;
            if (n == maxK) maxI = i;
            if (n < minK || n > maxK) index = i;
            res += Math.max(Math.min(minI, maxI) - index, 0);
        }
        return res;
    }
}
