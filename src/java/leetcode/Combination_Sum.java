package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 组合之和
 * @author: yaoweihao
 * @date: 2018/10/3
 * @time: 10:45
 * @modified by:
 */
public class Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        combinationSum(candidates, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> integerList = new ArrayList<>();
            int temp = 0;
            if (candidates[i] <= target) {
                combination(candidates, lists, integerList, target, temp, i);
            }
        }
        return lists;
    }

    private static void combination(int[] candidates, List<List<Integer>> lists, List<Integer> integerList, int target, int temp, int i) {
        if (temp + candidates[i] == target) {
            List<Integer> copy = new ArrayList<>(integerList);
            copy.add(candidates[i]);
            lists.add(copy);
        } else if (temp + candidates[i] < target) {
            List<Integer> copy = new ArrayList<>(integerList);
            copy.add(candidates[i]);
            temp = temp + candidates[i];
            for (int j = i; j < candidates.length; j++) {
                combination(candidates, lists, copy, target, temp, j);
            }
        }
    }
}
