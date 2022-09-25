package weeklyContest.WeeklyContest312;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-09-25 15:22
 * @Description: You are given a 0-indexed integer array nums of size n and a positive integer k.
 * <p>
 * We call an index i in the range k <= i < n - k good if the following conditions are satisfied:
 * <p>
 * The k elements that are just before the index i are in non-increasing order.
 * The k elements that are just after the index i are in non-decreasing order.
 * Return an array of all good indices sorted in increasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,1,1,1,3,4,1], k = 2
 * Output: [2,3]
 * Explanation: There are two good indices in the array:
 * - Index 2. The subarray [2,1] is in non-increasing order, and the subarray [1,3] is in non-decreasing order.
 * - Index 3. The subarray [1,1] is in non-increasing order, and the subarray [3,4] is in non-decreasing order.
 * Note that the index 4 is not good because [4,1] is not non-decreasing.
 * Example 2:
 * <p>
 * Input: nums = [2,1,1,2], k = 2
 * Output: []
 * Explanation: There are no good indices in this array.
 */
public class Contest2420GoodIndices {
    boolean h = false;
    boolean d = false;
    int hr = 0;
    int dr = 0;

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;

        for (int i = k; i < n - k; ) {
            if (h) {
                if (nums[i - 1] <= hr) {
                    hr = nums[i - 1];
                } else {
                    hr = 0;
                    h = false;
                }
            }
            if (d) {
                if (nums[i + k] >= dr) {
                    dr = nums[i + k];
                } else {
                    dr = 0;
                    d = false;
                }
            }
            if (h && d) {
                res.add(i);
            } else {
                if (checkH(nums, i - k, i - 1) && checkD(nums, i + 1, i + k)) res.add(i);
            }
            i++;

        }
        return res;
    }

    private boolean checkH(int[] nums, int start, int end) {
        int pre = 10000007;
        for (int i = start; i <= end; i++) {
            if (nums[i] > pre) return false;
            pre = nums[i];
        }
        h = true;
        hr = nums[end];
        return true;

    }

    private boolean checkD(int[] nums, int start, int end) {
        int pre = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < pre) return false;
            pre = nums[i];
        }
        d = true;
        dr = nums[end];

        return true;
    }
}
