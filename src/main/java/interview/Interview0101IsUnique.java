package interview;

/**
 * @author: PhilipFry
 * @create: 2022-08-04 23:27
 * @Description: 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 */
public class Interview0101IsUnique {
    public boolean isUnique(String astr) {
        int n = astr.length();
        int[] array = new int[256];
        char[] chars = astr.toCharArray();
        for (int i = 0; i < n; i++) {
            if (array[chars[i]] == 1) return false;
            array[chars[i]]++;
        }
        return true;
    }
}
