package leetcode.code50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-08 10:40
 * @Description: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 */
public class Code15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        if (nums.length < 3) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int t = nums[left] + nums[right] + nums[i];

                if (t > 0) {
                    right--;
                    continue;
                }
                if (t < 0) {
                    left++;
                    continue;
                }

                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                do {
                    left++;
                } while (left < right && nums[left - 1] == nums[left]);
                do {
                    right--;
                } while (left < right && nums[right + 1] == nums[right]);
            }
        }
        return res;
    }
}
