package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-19 21:50
 * @Description: Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class Code567CheckInclusion {
    int[] dic = new int[26];

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        char[] chars = s1.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            dic[chars[i] - 'a']++;
        }

        for (int i = 0, j = s1.length(); j <= s2.length(); j++, i++) {
            String s = s2.substring(i, j);
            if (check(s)) return true;
        }
        return false;
    }

    private boolean check(String s) {
        char[] chars = s.toCharArray();
        int[] con = new int[26];
        for (int i = 0; i < s.length(); i++) {
            con[chars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (dic[i] != con[i]) return false;
        }
        return true;
    }
}
