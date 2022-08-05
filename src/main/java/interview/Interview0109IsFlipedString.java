package interview;

/**
 * @author: PhilipFry
 * @create: 2022-08-05 23:44
 * @Description: 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 */
public class Interview0109IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        return (s2 + s2).contains(s1);
    }
}
