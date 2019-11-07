package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 全排序2
 * @author: showtime
 * @create: 2018-10-06 09:29
 **/
public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buff = new ArrayList<>();
        List<Integer> candidates = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            candidates.add(nums[i]);
        }
        backtracking(buff,candidates,result);
        return result;
    }
    public void backtracking(List<Integer> buff, List<Integer> candidates, List<List<Integer>> result) {
        if (candidates.size() == 0) { result.add(new ArrayList<Integer>(buff)); return; }
        for (int i = 0; i < candidates.size(); i++) {
            int temp = candidates.get(i);
            buff.add(temp);
            candidates.remove(i);
            backtracking(buff,candidates,result);
            candidates.add(i,temp);
            buff.remove(buff.size()-1);
            while (i+1 < candidates.size() && candidates.get(i+1).equals(candidates.get(i))) { i++; } // skip duplicates
        }
    }
}
