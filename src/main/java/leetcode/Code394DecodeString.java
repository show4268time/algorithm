package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-30 15:27
 * @Description: 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Code394DecodeString {

    Integer index = 0;

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        return dfs(chars);
    }

    String dfs(char[] chars) {
        String res = "";
        while (index < chars.length && chars[index] != ']') {
            if (chars[index] >= 'a' && chars[index] <= 'z') {
                res += chars[index++];
            } else if (chars[index] >= '0' && chars[index] <= '9') {
                int k = index;
                String n = "";
                while (chars[k] >= '0' && chars[k] <= '9') n += chars[k++];
                int num = Integer.valueOf(n);
                index = k + 1;
                String cur = dfs(chars);
                index++;
                while (num > 0) {
                    res += cur;
                    num--;
                }
            }
        }
        return res;
    }
}
