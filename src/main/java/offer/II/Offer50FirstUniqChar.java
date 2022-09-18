package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-18 23:03
 * @Description: 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 *  
 */
public class Offer50FirstUniqChar {
    public char firstUniqChar(String s) {
        char[] chars = new char[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1) return s.charAt(i);
        }

        return ' ';
    }
}
