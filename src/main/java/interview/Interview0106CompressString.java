package interview;

/**
 * @author: PhilipFry
 * @create: 2022-08-04 23:46
 * @Description: 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 */
public class Interview0106CompressString {
    public String compressString(String S) {
        if (S == null || S.length() <= 2) return S;
        int n = S.length();
        char[] chars = S.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
            } else {
                sb.append(count).append(chars[i]);
                count = 1;
            }
        }
        sb.append(count);
        String res = sb.toString();
        return res.length() < n ? res : S;
    }
}
