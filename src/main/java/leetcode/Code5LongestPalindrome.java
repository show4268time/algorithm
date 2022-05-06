package main.java.leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-06 10:27
 * @Description: Given a string s, return the longest palindromic substring in s.
 */
public class Code5LongestPalindrome {
    private int max = 0;

    private String res = "";

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            longestPalindrome(s, i, i);
            longestPalindrome(s, i, i + 1);
        }

        return res;
    }

    public void longestPalindrome(String s, int left, int right) {
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
