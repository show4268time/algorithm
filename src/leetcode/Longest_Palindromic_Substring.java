package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最长回文数
 * @author: yaoweihao
 * @date: 2018/9/14
 * @time: 17:50
 * @modified by:
 */
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "cbbd";
        longestPalindrome(s);
    }

    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        char[] chars = s.toCharArray();
        String str = String.valueOf(chars[0]);
        for (int i = 1; i < chars.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            StringBuilder sb = new StringBuilder();
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    if (sb.length() == 0) {
                        sb.append(chars[left]).append(chars[i]).append(chars[right]);
                    } else {
                        sb.insert(0, chars[left]).append(chars[right]);
                    }
                    left--;
                    right++;
                    if (sb.length() > str.length()) {
                        str = sb.toString();
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int m = i;
            int n = i + 1;
            StringBuilder sb = new StringBuilder();
            while (m >= 0 && n < chars.length) {
                if (chars[n] == chars[m]) {
                    sb.insert(0, chars[m]).append(chars[n]);

                    if (sb.length() > str.length()) {
                        str = sb.toString();
                    }
                    m--;
                    n++;
                } else {
                    break;
                }
            }
        }
        return str;
    }
}
