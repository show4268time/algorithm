package leetcode.code100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-04 08:46
 * @Description: Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 */
public class Code90SubsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        int temp = index;
        while (temp < nums.length && nums[temp] == nums[index]) temp++;
        int count = temp - index;

        for (int i = 0; i <= count; i++) {
            dfs(nums, temp);
            path.add(nums[index]);
        }

        for (int i = 0; i <= count; i++) {
            path.removeLast();
        }
    }
}
