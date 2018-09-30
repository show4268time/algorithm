package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 找出目标数字的上界和下界
 * @author: yaoweihao
 * @date: 2018/9/29
 * @time: 9:37
 * @modified by:
 */
public class Search_For_Range {
    public static void main(String[] args){
        int[] nums = new int[] {5,7,7,8,8,10};
        searchRange(nums, 8);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[0] = searchLowBound(nums, target, left, mid);
                result[1] = searchHighBound(nums, target, mid, right);
                return result;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return result;
    }

    // 找目标数下界
    public static int searchLowBound(int[] nums, int target, int lowBound, int lowCertain) {
        int result = lowCertain;
        while (lowBound <= lowCertain) {
            int mid = lowBound + (lowCertain - lowBound) / 2;
            if (nums[mid] == target) {
                result = mid;
                lowCertain = mid - 1;
            } else {
                lowBound = mid + 1;
            }
        }
        return result;
    }

    // 找目标数上界
    public static int searchHighBound(int[] nums, int target, int highCertain, int highBound) {
        int result = highCertain;
        while (highCertain <= highBound) {
            int mid = highCertain + (highBound - highCertain) / 2;
            if (nums[mid] == target) {
                result = mid;
                highCertain = mid + 1;
            } else {
                highBound = mid - 1;
            }
        }
        return result;
    }
}
