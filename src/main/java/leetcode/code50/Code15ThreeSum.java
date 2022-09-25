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

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int m = nums[i] + nums[l] + nums[r];
                if (m > 0) {
                    r--;
                    continue;
                } else if (m < 0) {
                    l++;
                    continue;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    do {
                        l++;
                    } while (l < r && nums[l - 1] == nums[l]);

                    do {
                        r--;
                    } while (l < r && nums[r + 1] == nums[r]);
                }
            }
        }
        return res;
    }
}
