package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-04 16:54
 * @Description: Find all valid combinations of k numbers that sum (总和) up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used. Each number is used at most once.
 * Return a list of all possible valid combinations.
 * The list must not contain the same combination twice, and the combinations may be returned in any order.
 */
public class Code216CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, 0);
        return result;
    }

    private void dfs(int k, int n, int index, int sum) {
        if (path.size() > k || sum > n) return;
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
        }

        for (int i = index; i <= 9 && i + sum <= n; i++) {
            path.add(i);
            dfs(k, n, i + 1, sum + i);
            path.removeLast();
        }
    }
}
