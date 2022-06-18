package leetcode.code50;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class Code3LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] array = new int[128];
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            array[s.charAt(right)]++;
            while (array[s.charAt(right)] > 1) {
                array[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
