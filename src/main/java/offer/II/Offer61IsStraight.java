package offer.II;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-09-23 23:13
 * @Description: 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Offer61IsStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return false;
            if (nums[i] == 0) continue;
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min < 5;
    }
}
