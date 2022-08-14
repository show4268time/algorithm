package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-14 11:15
 * @Description: Given a string array words, return the maximum value of length(word[i]) * length(word[j])
 * <p>
 * where the two words do not share common letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class Code318MaxProduct {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (char c : words[i].toCharArray()) {
                int m = c - 'a';
                t |= 1 << m;
            }
            hash[i] = t;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
