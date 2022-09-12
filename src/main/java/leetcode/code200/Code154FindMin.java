package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-09-11 16:34
 * @Description: Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * <p>
 * You must decrease the overall operation steps as much as possible.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,0,1]
 * Output: 0
 */
public class Code154FindMin {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r && nums[r] == nums[0]) r--;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r] > nums[0] ? nums[0] : nums[r];
    }
}
