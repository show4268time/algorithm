package leetcode.code100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-04 08:52
 * @Description: Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Code78Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new LinkedList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, index + 1, path);
        path.add(nums[index]);
        dfs(nums, index + 1, path);
        path.removeLast();
    }
}
