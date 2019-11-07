package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最长回文数
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author: yaoweihao
 * @date: 2018/9/14
 * @time: 17:50
 * @modified by:
 */
public class P5_Longest_Palindromic_Substring {

    private static int max = 0;

    private static String res = "";

    public static void main(String[] args) {
        longestPalindrome("babad");
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            longestPalindrome(s, i, i);
            longestPalindrome(s, i, i + 1);
        }
        return res;
    }

    public static void longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1) {
            if (s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            } else {
                return;
            }
        }
    }
}
