package leetcode.code50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-30 21:02
 * @Description: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Code22GenerateParenthesis {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, "", n);
        return res;
    }

    private void dfs(int leftCount, int rightCount, String pre, int n) {
        if (leftCount == n && rightCount == n) {
            res.add(pre);
            return;
        }

        if (leftCount < n) {
            dfs(leftCount + 1, rightCount, pre + "(", n);
        }


        if (rightCount < n && leftCount > rightCount) {
            dfs(leftCount, rightCount + 1, pre + ")", n);
        }
    }
}
