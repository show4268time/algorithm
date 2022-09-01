package leetcode.code50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-03 23:04
 * @Description: Given an array of distinct integers candidates and a target integer target,
 * <p>
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * <p>
 * You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * <p>
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class Code39CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index == candidates.length) return;

        for (int i = 0; i * candidates[index] <= target; i++) {
            dfs(candidates, target - i * candidates[index], index + 1);
            path.add(candidates[index]);
        }

        for (int i = 0; candidates[index] * i <= target; i++) {
            path.removeLast();
        }
    }
}
