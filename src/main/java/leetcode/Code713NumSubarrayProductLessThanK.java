package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-20 17:15
 * @Description: Given an array of integers nums and an integer k,
 * <p>
 * return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */
public class Code713NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        if (k <= 1) return res;
        int cur = 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            cur *= nums[i];
            while (cur >= k) cur /= nums[j++];
            res += i - j + 1;
        }
        return res;
    }
}
