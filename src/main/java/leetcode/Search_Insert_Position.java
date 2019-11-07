package leetcode;

/**
 * @program: algorithm
 * @description: 搜索插入位置
 * @author: showtime
 * @create: 2018-09-09 10:49
 **/
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        if(target < nums[0]) return 0;
        if(target == nums[nums.length - 1]) return nums.length - 1;

        if(target > nums[nums.length - 1]) return nums.length;

        for (int i = 0; i < nums.length - 1; i++){
            if(target == nums[i]) return i;
            if(target > nums[i] && target < nums[i + 1]){
                return i + 1;
            }
        }

        return 0;
    }
}
