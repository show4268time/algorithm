package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 * @author: yaoweihao
 * @date: 2018/12/16
 * @time: 10:50
 * @modified by:
 */
public class Subsets_II {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};
        subsetsWithDup(nums);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        subsets(nums, 0, result, temp);
        return new ArrayList<>(result);
    }

    private static void subsets(int[] nums, int i, Set<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));

        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);

            subsets(nums, j+1, result, temp);
            temp.remove(temp.size() - 1);
        }

    }
}
