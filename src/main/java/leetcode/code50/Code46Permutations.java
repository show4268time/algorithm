package leetcode.code50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-16 09:19
 * @Description: Given an array nums of distinct integers, return all the possible permutations.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 */
public class Code46Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            dfs(nums, path);
            path.removeLast();
        }
    }
}
