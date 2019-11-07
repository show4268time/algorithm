package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 在旋转有序数组中搜索
 * @author: yaoweihao
 * @date: 2018/9/27
 * @time: 17:15
 * @modified by:
 */
public class Search_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            //右边的数据是排序的
            if (nums[mid] <= nums[right]) {
                //在排序数列中
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //左边的数据是排序的
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }

        return -1;
    }
}
