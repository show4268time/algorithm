package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-08 13:02
 * @Description: Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.  You may assume that each input would have exactly one solution.
 */
public class Code16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int diff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int n = nums[i] + nums[left] + nums[right];

                if (target < n) {
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    int abs = Math.abs(target - n);
                    if (abs < diff) {
                        diff = abs;
                        result = n;
                    }
                    right--;
                } else if (target > n) {
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    int abs = Math.abs(target - n);
                    if (abs < diff) {
                        diff = abs;
                        result = n;
                    }
                    left++;
                } else {
                    return target;
                }


                while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return result;

    }
}
