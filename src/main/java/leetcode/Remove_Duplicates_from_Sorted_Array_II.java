package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author: yaoweihao
 * @date: 2018/12/6
 * @time: 18:12
 * @modified by:
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1, num = nums.length, temp = 1;
        int cou = nums[0];
        while (fast < nums.length) {
            if (nums[fast] == cou) {
                temp++;
                if (temp < 3) {
                    nums[slow] = nums[fast];
                    slow++;
                }else {
                    num--;
                }
            } else {
                cou = nums[fast];
                nums[slow] = nums[fast];
                temp = 1;
                slow++;
            }
            fast++;
        }
        return num;
    }
}
