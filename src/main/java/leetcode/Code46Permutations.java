package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-16 09:19
 * @Description: Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Code46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, result);

        return result;
    }

    public void backtrack(int[] nums, LinkedList track, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, result);
            track.removeLast();
        }
    }
}
