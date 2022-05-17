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
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);

        return result;
    }

    public void backtrack(int[] nums) {
        if(track.size() == nums.length){
            result.add(new LinkedList<>(track));
        }

        for(int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            used[i] = Boolean.TRUE;
            track.add(nums[i] );
            backtrack(nums);
            track.removeLast();
            used[i] = Boolean.FALSE;
        }
    }
}
