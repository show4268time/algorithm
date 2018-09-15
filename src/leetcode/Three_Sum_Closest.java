package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 就当成标准的3Sum来做。维护一个和target的最小差和最终结果。
 * 每次获得和target更接近的结果，就更新最小差和最终结果。
 * @author: yaoweihao
 * @date: 2018/9/15
 * @time: 13:41
 * @modified by:
 */
public class Three_Sum_Closest {
    public static void main(String[] args){
        int[] nums = new int[]{-1,2,1,-4};
        threeSumClosest(nums, 1);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int minNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int n = nums[i] + nums[left] + nums[right];
                if (target > n) {
                    if(Math.abs(target - n) < minDiff){
                        minDiff = Math.abs(target - n);
                        minNum = n;
                    }
                    left++;
                } else if (target < n) {
                    if(Math.abs(target - n) < minDiff){
                        minDiff = Math.abs(target - n);
                        minNum = n;
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }
        return minNum;
    }
}
