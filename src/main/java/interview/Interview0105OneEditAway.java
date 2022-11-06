package interview;

/**
 * @author: PhilipFry
 * @create: 2022-11-06 21:12
 * @Description: 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Interview0105OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();

        if (Math.abs(n - m) > 1) return false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (first.charAt(i) != second.charAt(j)) {
                return oneEditAway(first, i + 1, second, j + 1) || oneEditAway(first, i, second, j + 1) || oneEditAway(first, i + 1, second, j);
            }
            i++;
            j++;
        }
        return true;
    }

    public boolean oneEditAway(String first, int i, String second, int j) {
        int n = first.length();
        int m = second.length();
        if (n - i != m - j) return false;
        while (i < n && j < n) {
            if (first.charAt(i) != second.charAt(j)) return false;
            i++;
            j++;
        }
        return true;
    }
}
