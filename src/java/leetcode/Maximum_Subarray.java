package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最大子数组
 * @author: yaoweihao
 * @date: 2018/10/10
 * @time: 11:42
 * @modified by:
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int heritage = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int assets = heritage + nums[i];
            max = Math.max(max, assets);
            heritage = Math.max(assets, 0);
        }
        return max;
    }
}
