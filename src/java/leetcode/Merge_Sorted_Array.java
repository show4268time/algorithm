package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 * @author: yaoweihao
 * @date: 2018/12/13
 * @time: 18:34
 * @modified by:
 */
public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1;
        int cursor = m + n - 1;
        while (tail1 >= 0 || tail2 >= 0) {
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            if (tail1 >= 0) { first = nums1[tail1]; }
            if (tail2 >= 0) { second = nums2[tail2]; }
            if (first >= second) {
                nums1[cursor--] = nums1[tail1--];
            } else {
                nums1[cursor--] = nums2[tail2--];
            }
        }
    }
}
