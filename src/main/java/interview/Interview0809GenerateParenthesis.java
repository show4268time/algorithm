package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-12-26 00:08
 * @Description: 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Interview0809GenerateParenthesis {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, n, "");
        return result;
    }

    private void dfs(int left, int right, int n, String pre) {
        if (pre.length() == n * 2) {
            result.add(pre);
            return;
        }

        if (left > 0) {
            left--;
            dfs(left, right, n, pre + "(");
            left++;
        }

        if (left < right) {
            right--;
            dfs(left, right, n, pre + ")");
            right++;
        }
    }
}
