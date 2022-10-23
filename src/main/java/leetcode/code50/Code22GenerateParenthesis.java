package leetcode.code50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-30 21:02
 * @Description: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Code22GenerateParenthesis {
    int left = 0;
    int right = 0;
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        left = n;
        right = n;
        dfs("", n);
        return res;
    }

    private void dfs(String pre, int n) {
        if (right == 0 && left == 0) {
            res.add(pre);
            return;
        }

        if (left > 0) {
            left--;
            dfs(pre + "(", n);
            left++;
        }
        if (right > 0 && right > left) {
            right--;
            dfs(pre + ")", n);
            right++;
        }
    }
}
