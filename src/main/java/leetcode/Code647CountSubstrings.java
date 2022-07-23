package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-23 00:08
 * @Description: 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Code647CountSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        s = s + " ";
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (check(sub)) {
                    dp[i] = dp[i] + 1;
                }
            }
        }
        return dp[n];
    }


    private boolean check(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        char[] chars = s.toCharArray();
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
