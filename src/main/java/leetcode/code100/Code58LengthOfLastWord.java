package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-09-08 00:03
 * @Description: Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
public class Code58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        boolean start = false;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] != ' ') {
                res++;
                start = true;
            } else {
                if (start) break;
            }
        }
        return res;
    }
}
