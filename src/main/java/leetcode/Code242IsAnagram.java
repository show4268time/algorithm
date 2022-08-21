package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-21 19:19
 * @Description: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * <p>
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Code242IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
