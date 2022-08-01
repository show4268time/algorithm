package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-07-30 23:02
 * @Description: Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class Code560SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
            res += map.getOrDefault(n - k, 0);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return res;
    }
}
