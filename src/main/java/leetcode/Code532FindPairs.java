package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-06-17 23:38
 * @Description: Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 * <p>
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 * <p>
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * Notice that |val| denotes  the absolute  value of val.
 */
public class Code532FindPairs {
    Set<String> set = new HashSet<>();

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        if (k >= 0) {
            for (int i = 0; i < nums.length; i++) {
                check1(nums, k, i);
            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                check1(nums, k, i);
            }
        }

        return set.size();
    }

    private void check1(int[] nums, int k, int index) {
        int n = nums[index];
        int i = index + 1;
        while (i < nums.length) {
            if (nums[i] - n == k) {
                set.add(nums[index] + "_" + n);
                return;
            } else if (nums[index] - n > k) {
                return;
            }
            i++;
        }
    }

    private void check2(int[] nums, int k, int index) {
        int n = nums[index];
        int i = index - 1;
        while (i >= 0) {
            if (nums[i] - n == k) {
                set.add(nums[index] + "_" + n);
                return;
            } else if (nums[index] - n < k) {
                return;
            }
            i--;
        }
    }
}
