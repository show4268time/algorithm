package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 全排序
 * @author: showtime
 * @create: 2018-10-05 09:21
 **/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //选LinkedList为了插入，删除操作快
        List<Integer> candidates = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            candidates.add(nums[i]);
        }

        backtracking(result, candidates, temp);
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> candidates, List<Integer> temp){
        if (candidates.size() == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < candidates.size(); i++){
                int n = candidates.get(i);
                temp.add(n);
                candidates.remove(i);
                backtracking(result, candidates, temp);
                candidates.add(i, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
