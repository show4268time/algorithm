package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-20 10:28
 * @Description: Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: false
 */
public class Code680ValidPalindrome {
    int count = 1;

    public boolean validPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private boolean check(String s, int l, int r) {
        if (l >= r) return true;

        if (s.charAt(l) == s.charAt(r)) {
            return check(s, l + 1, r - 1);
        } else {
            if (count == 1) {
                --count;
                return check(s, l, r - 1) || check(s, l + 1, r);
            } else {
                return false;
            }
        }
    }
}
