package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-08-19 23:07
 * @Description: Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Code438FindAnagrams {
    public List<Integer> findAnagrams(String p, String s) {
        int n = s.length();
        int m = p.length();

        List<Integer> res = new ArrayList<>();
        if (n > m) return res;
        char[] c = s.toCharArray();
        int[] dic = new int[26];
        for (int i = 0; i < c.length; i++) {
            dic[c[i] - 'a']++;
        }
        int[] cur = new int[26];
        char[] chars = p.toCharArray();
        for (int i = 0; i < n; i++) {
            cur[chars[i] - 'a']++;
        }
        if (check(dic, cur)) res.add(0);
        for (int i = n; i < m; i++) {
            cur[chars[i] - 'a']++;
            cur[chars[i - n] - 'a']--;
            if (check(dic, cur)) res.add(i - n + 1);
        }
        return res;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
