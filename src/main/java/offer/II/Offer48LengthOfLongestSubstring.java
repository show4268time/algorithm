package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-18 21:38
 * @Description: 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 */
public class Offer48LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] dic = new int[256];
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (dic[c] > 0) {
                dic[s.charAt(j++)]--;
            }
            dic[c]++;
            int n = i - j + 1;
            res = Math.max(res, n);
        }
        return res;
    }
}
