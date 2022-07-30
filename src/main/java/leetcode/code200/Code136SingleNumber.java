package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-07-09 22:21
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Code136SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int x : nums){
            //不需要额外空间的方法，就往位运算上想
            res ^= x;
        }
        return res;
    }
}
