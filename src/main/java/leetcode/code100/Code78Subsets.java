package leetcode.code100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-04 08:52
 * @Description: Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Code78Subsets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, index + 1);

        path.add(nums[index]);
        dfs(nums, index + 1);
        path.removeLast();
    }
}
