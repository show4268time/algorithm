package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 组合之和2
 * @author: yaoweihao
 * @date: 2018/10/3
 * @time: 16:47
 * @modified by:
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> integerList = new ArrayList<>();
            int temp = 0;
            if (candidates[i] <= target) {
                combination(candidates, result, integerList, target, temp, i);
            }
        }
        return result;
    }

    private static void combination(int[] candidates, List<List<Integer>> lists, List<Integer> integerList, int target, int temp, int i) {
        if (temp + candidates[i] == target) {
            List<Integer> copy = new ArrayList<>(integerList);
            copy.add(candidates[i]);
            if (!lists.contains(copy)) {
                lists.add(copy);
            }
        } else if (temp + candidates[i] < target) {
            List<Integer> copy = new ArrayList<>(integerList);
            copy.add(candidates[i]);
            temp = temp + candidates[i];
            for (int j = i + 1; j < candidates.length; j++) {
                combination(candidates, lists, copy, target, temp, j);
            }
        }
    }
}
