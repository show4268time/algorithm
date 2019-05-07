package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 下一个排列
 * @author: yaoweihao
 * @date: 2018/9/27
 * @time: 9:55
 * @modified by:
 */
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int toSwap = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                toSwap = i - 1;
                break;
            }
        }
        if (toSwap >= 0) {
            int anotherToSwap = 0;
            for (int i = nums.length - 1; i > toSwap; i--) {
                if (nums[i] > nums[toSwap]) {
                    anotherToSwap = i;
                    break;
                }
            }
            swap(nums, toSwap, anotherToSwap);
        }
        reverseSort(nums, toSwap + 1, nums.length - 1);
    }

    public void swap(int[] nums, int high, int low) {
        int temp = nums[high];
        nums[high] = nums[low];
        nums[low] = temp;
    }

    public void reverseSort(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }
}
