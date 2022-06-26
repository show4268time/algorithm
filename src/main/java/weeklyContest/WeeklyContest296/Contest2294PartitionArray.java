package weeklyContest.WeeklyContest296;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-06-05 13:09
 * @Description: You are given an integer array (阵列) nums and an integer k.
 * You may partition (分区) nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
 * Return the minimum (最低) number of subsequences needed such that the difference between the maximum (最大) and minimum (最低) values in each subsequence is at most k.
 * A subsequence is a sequence (序列) that can be derived (派生) from another sequence by deleting (删除) some or no elements without changing the order of the remaining elements.
 */
public class Contest2294PartitionArray {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] <= k) {
                right++;
            } else {
                count++;
                left = right;
            }
        }
        count++;
        return count;
    }
}
