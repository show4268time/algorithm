package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-08-20 00:12
 * @Description: Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class Code76MinWindow {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        char[] chars = t.toCharArray();
        int[] a = new int[128];
        StringBuilder sb = new StringBuilder();
        String res = "";
        int count = Integer.MAX_VALUE;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            a[chars[i] - 'A']++;
        }
        char[] c = s.toCharArray();
        int[] b = new int[128];
        for (int i = 0; i < n; i++) {
            b[c[i] - 'A']++;
            sb.append(c[i]);
        }
        if (check(a, b)) {
            res = sb.toString();
            count = res.length();
        }
        for (int i = n, j = 0; i < c.length; i++) {
            b[c[i] - 'A']++;
            sb.append(c[i]);
            while (check(a, b)) {
                String cur = sb.toString();
                if (cur.length() < count) {
                    res = cur;
                    count = res.length();
                }
                b[c[j++] - 'A']--;
                sb.deleteCharAt(0);
            }
        }
        return res;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 128; i++) {
            if (a[i] > b[i]) return false;
        }
        return true;
    }
}
