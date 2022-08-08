package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-08-08 23:33
 * @Description: 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 */
public class Interview0807Permutation {
    List<String> res = new ArrayList<>();

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] isVisited = new boolean[S.length()];
        dfs(chars, "", isVisited);
        String[] result = new String[res.size()];
        return res.toArray(result);
    }

    private void dfs(char[] chars, String pre, boolean[] isVisited) {
        if (pre.length() == chars.length) {
            res.add(pre);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            dfs(chars, pre + chars[i], isVisited);
            isVisited[i] = false;
        }
    }
}
