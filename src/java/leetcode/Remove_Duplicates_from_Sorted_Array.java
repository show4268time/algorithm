package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 有序数组中去除重复项
 * @author: yaoweihao
 * @date: 2018/9/7
 * @time: 9:45
 * @modified by:
 */
public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] arg){
        int[] nums = new int[]{1, 1, 2};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int fast = 0;
        int slow = 0;
        int max = nums[slow];

        while (fast < nums.length){
            if(nums[fast] > max){
                nums[++slow] = nums[fast];
                max = nums[slow];
            }
            fast++;
        }

        return ++slow;
    }
}
