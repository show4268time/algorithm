package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-12-24 16:27
 * @Description: 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Interview0808Permutation {
    List<String> result = new ArrayList<>();
    boolean[] used;

    public String[] permutation(String S) {
        used = new boolean[S.length()];
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        dfs(chars, "");
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    private void dfs(char[] chars, String pre) {
        if (pre.length() == chars.length) {
            result.add(pre);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            dfs(chars, pre + chars[i]);
            used[i] = false;
        }
    }
}
