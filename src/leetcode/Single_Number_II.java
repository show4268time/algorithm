package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
 * @author: yaoweihao
 * @date: 2019/4/8
 * @time: 14:06
 * @modified by:
 */
public class Single_Number_II {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }
}
