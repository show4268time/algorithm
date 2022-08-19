package leetcode.code50;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Code3LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int[] cur = new int[128];
        for (int i = 0, j = 0; i < chars.length; i++) {
            while (cur[chars[i]] == 1) {
                cur[chars[j++]]--;
            }
            cur[chars[i]]++;
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
