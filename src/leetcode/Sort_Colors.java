package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author: yaoweihao
 * @date: 2018/11/22
 * @time: 13:28
 * @modified by:
 */
public class Sort_Colors {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        threeWayPartition(nums, 1);
    }

    public static void threeWayPartition(int[] nums, int target) {
        int lessThan = 0, greaterThan = nums.length - 1, cursor = lessThan + 1;
        while (cursor <= greaterThan) {
            if (nums[cursor] < target) {
                exchange(nums, ++lessThan, cursor++); // 简化在这里，因为不论有没有等于target的数，这里cursor都是加1的。
            } else if (nums[cursor] > target) {
                exchange(nums, --greaterThan, cursor);
            } else {
                cursor++;
            }
        }
    }

    public static void exchange(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
