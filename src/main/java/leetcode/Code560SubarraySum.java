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
        int n = nums.length;
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = array[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int t = array[i];
            int d = t - k;
            res += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return res;
    }
}
