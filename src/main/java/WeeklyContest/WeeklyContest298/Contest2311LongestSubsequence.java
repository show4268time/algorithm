package WeeklyContest.WeeklyContest298;

/**
 * @author: PhilipFry
 * @create: 2022-06-26 14:24
 * @Description: You are given a binary string s and a positive integer k.
 * <p>
 * Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
 * <p>
 * Note:
 * <p>
 * The subsequence can contain leading zeroes.
 * The empty string is considered to be equal to 0.
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing
 * the order of the remaining characters.
 */
public class Contest2311LongestSubsequence {
    /**
     * 正确解法
     * 从右往左统计1的个数，最后加上所有0的个数，直至大于k或超出int上限
     * @param s
     * @param k
     * @return
     */
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') zero++;
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') {
                if (n - i > 32) break;
                if (Long.parseLong(s.substring(i), 2) > k) {
                    break;
                }
                one++;
            }
        }
        return zero + one;
    }

    /**
     * 有超过32位问题
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestSubsequenceError(String s, int k) {
        int n = s.length();
        String str = "";
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                str = c + str;
            } else {
                if (Integer.parseInt(c + str, 2) < k) {
                    str = c + str;
                }
            }
        }
        return str.length();
    }
}
