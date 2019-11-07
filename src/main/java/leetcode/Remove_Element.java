package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 移除元素
 * 除一个数组中和给定值相同的数字，并返回新的数组的长度。
 * @author: yaoweihao
 * @date: 2018/9/7
 * @time: 12:50
 * @modified by:
 */
public class Remove_Element {
    public static void main(String[] arg){
        int[] nums = new int[]{3,2,2,3};

        removeElement(nums, 3);
    }
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 ) return 0;

        int f = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[f] = nums[i];
                f++;
            }else {
                continue;
            }
        }
        return f;
    }
}
