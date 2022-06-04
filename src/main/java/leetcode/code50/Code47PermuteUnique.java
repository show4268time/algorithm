package leetcode.code50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-04 15:15
 * @Description: Given a collection of numbers, nums, that might contain duplicates (重复) ,
 * return all possible unique permutations (置换) in any order.
 */
public class Code47PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;


            if(i > 0 && nums[i -1] == nums[i] && !used[i -1]) continue;

            used[i]=true;
            path.add(nums[i]);
            dfs(nums);
            path.removeLast();
            used[i]=false;
        }
    }
}
