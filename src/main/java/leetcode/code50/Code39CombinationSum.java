package leetcode.code50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-03 23:04
 * @Description: Given an array (阵列) of distinct (鲜明) integers (整数) candidates and a target integer (整数) target,
 * return a list of all unique combinations of candidates where the chosen numbers sum (总和) to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited (无限) number of times.
 * Two combinations are unique if the frequency (频率) of at least one of the chosen numbers is different.
 * It is guaranteed (保证) that the number of unique combinations that sum (总和) up to target is less than 150 combinations for the given input.
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
