package interview;

/**
 * @author: PhilipFry
 * @create: 2022-11-06 18:26
 * @Description: URL化。编写一种方法，将字符串中的空格全部替换为%20。
 *
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例 1：
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 */
public class Interview0103ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
