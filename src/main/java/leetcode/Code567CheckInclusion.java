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
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] dic1 = new int[26];
        int[] dic2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            dic1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            dic2[s2.charAt(i) - 'a']++;
        }

        if (check(dic1, dic2)) return true;

        int l = 0, r = s1.length();
        while (r < s2.length()) {
            dic2[s2.charAt(l++) - 'a']--;
            dic2[s2.charAt(r++) - 'a']++;
            if (check(dic1, dic2)) return true;
        }
        return false;

    }


    private boolean check(int[] dic1, int[] dic2) {
        for (int i = 0; i < 26; i++) {
            if (dic2[i] != dic1[i]) return false;
        }
        return true;
    }
}
