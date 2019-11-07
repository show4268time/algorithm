package leetcode;

/**
 * @program: algorithm
 * @description: 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @author: showtime
 * @create: 2019-03-17 16:01
 **/
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo <= hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) { lo++; continue; }
            if (!Character.isLetterOrDigit(s.charAt(hi))) { hi--; continue; }
            if (Character.toLowerCase(s.charAt(lo++)) != Character.toLowerCase(s.charAt(hi--))) { return false; }
        }
        return true;
    }
}
