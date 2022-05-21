package leetcode.code50;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class Code3LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int fastCursor = 0;
        int slowCursor = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (fastCursor < s.length()) {
            if (!set.contains(s.charAt(fastCursor))) {
                set.add(s.charAt(fastCursor++));
                max = Math.max(max,set.size());
            } else {
                set.remove(s.charAt(slowCursor++));
            }
        }
        return max;
    }
}
