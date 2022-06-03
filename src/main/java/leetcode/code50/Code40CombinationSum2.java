package leetcode.code50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-03 23:49
 * @Description: Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 */
public class Code40CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);

        return res;
    }

    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (index == candidates.length) return;

        int temp = index;
        while (temp < candidates.length && candidates[temp] == candidates[index]) temp++;
        int count = temp - index;

        for (int i = 0; i <= count && i * candidates[index] <= target; i++) {
            dfs(candidates, target - i * candidates[index], temp);
            path.add(candidates[index]);
        }

        for (int i = 0; i <= count && i * candidates[index] <= target; i++) {
            path.removeLast();
        }
    }
}
