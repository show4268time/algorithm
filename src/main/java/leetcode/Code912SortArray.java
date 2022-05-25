package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-25 08:33
 * @Description: Given an array of integers nums, sort the array in ascending order.
 */
public class Code912SortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int num = nums[left];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < num);

            do {
                j--;
            } while (nums[j] > num);

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }
}
