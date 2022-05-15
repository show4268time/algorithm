package WeeklyContest.WeeklyContest293;

/**
 * @author: PhilipFry
 * @create: 2022-05-15 15:03
 * @Description: The bitwise AND of an array nums is the bitwise AND of all integers in nums.
 * For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1. Also, for nums = [7], the bitwise AND is 7.
 * You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates.
 * Each number in candidates may only be used once in each combination.
 * Return the size of the largest combination of candidates with a bitwise AND greater than 0.
 */
public class Contest2275LargestCombination {
    public int largestCombination(int[] candidates) {
        // 记录该二进制位上值为1的元素的个数
        int[] n = new int[24];  //2的24次方 > 题目说取值最大为10的七次方，所以24位即可
        int max = 0;
        for(int c : candidates) {   // 遍历所有元素
            for(int i = 0; i < n.length; i++) { // 遍历每一二进制位
                if((c & (1 << i)) > 0) {    // 该位为1，则n[i]加1
                    n[i]++;
                }
            }
        }
        // 取二进制为元素的个数最大值
        for(int a : n) {
            max = Math.max(a, max);
        }
        return max;
    }
}
