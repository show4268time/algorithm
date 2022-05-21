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
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int main = 0;
        while (main < nums.length - 2) {
            if (nums[main] > 0) {
                break;
            }
            int low = main + 1;
            int high = nums.length - 1;
            while (low < high) {
                long sum = (long) (nums[main] + nums[low] + nums[high]);
                if (sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[main], nums[low], nums[high]})));
                }
                if (sum <= 0) {
                    while (low + 1 < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;
                }
                if (sum >= 0) {
                    while (low < high - 1 && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                }
            }
            while (main + 1 < nums.length - 2 && nums[main] == nums[main + 1]) {
                main++;
            }
            main++;
        }
        return result;
    }
}
