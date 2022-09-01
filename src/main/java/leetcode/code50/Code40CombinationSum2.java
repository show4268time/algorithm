package leetcode.code50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-03 23:49
 * @Description: Given a collection of candidate numbers (candidates) and a target number (target),
 * <p>
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
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
