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
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] dic1 = new int[26];
        int[] dic2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            dic1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            dic2[p.charAt(i) - 'a']++;
        }

        if (check(dic1, dic2))  result.add(0);

        int l = 0, r = p.length();
        while (r < s.length()) {
            dic1[s.charAt(l++) - 'a']--;
            dic1[s.charAt(r++) - 'a']++;
            if (check(dic1, dic2)) result.add(l);
        }
        return result;
    }

    private boolean check(int[] dic1, int[] dic2) {
        for (int i = 0; i < 26; i++) {
            if (dic2[i] != dic1[i]) return false;
        }
        return true;
    }
}
