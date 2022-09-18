package offer.II;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-09-18 20:56
 * @Description: 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 */
public class Offer46TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
