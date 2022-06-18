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
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        //确定第一个数
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                    continue;
                }
                if (sum < 0) {
                    l++;
                    continue;
                }
                //sum == 0时
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                //去除重复处理
                do {
                    l++;
                } while (l < r && nums[l] == nums[l - 1]);
                do {
                    r--;
                } while (l < r && nums[r] == nums[r + 1]);
            }

        }
        return ans;
    }
}
