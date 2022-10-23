package leetcode.code100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-04 16:22
 * @Description: Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Code77Combine {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new LinkedList<>());
        return res;
    }

    private void dfs(int n, int k, int index, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (index > n) {
            return;
        }

        dfs(n, k, index + 1, path);
        path.add(index);
        dfs(n, k, index + 1, path);
        path.removeLast();
    }
}
