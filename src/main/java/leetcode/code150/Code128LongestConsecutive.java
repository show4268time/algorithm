package leetcode.code150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-05-24 17:40
 * @Description: Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class Code128LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int count = 1;
        int max = 0;
        Arrays.sort(nums);
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] - nums[left] == 1) {
                count++;
            } else if (nums[right] - nums[left] == 0) {

            } else {
                count = 1;
            }
            max = Math.max(max, count);
            right++;
            left++;
        }
        return max;
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer x : set) {
            if (!set.contains(x - 1)) {
                int y = x;
                while (set.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);
            }
        }
        return res;
    }
}
