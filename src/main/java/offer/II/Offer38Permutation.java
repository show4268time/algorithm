package offer.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-09-18 10:00
 * @Description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Offer38Permutation {
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];

        Arrays.sort(chars);
        dfs(chars, used, "", 0);

        String[] result = new String[res.size()];
        return res.toArray(result);
    }

    private void dfs(char[] chars, boolean[] used, String path, int index) {
        if (index == chars.length) {
            res.add(path);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0) {
                if (chars[i - 1] == chars[i] && !used[i - 1]) continue;
            }
            used[i] = true;
            dfs(chars, used, path + chars[i], index + 1);
            used[i] = false;
        }
    }
}
