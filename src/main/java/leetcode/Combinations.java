package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author: yaoweihao
 * @date: 2018/11/27
 * @time: 17:41
 * @modified by:
 */
public class Combinations {
    public static void main(String[] args) {
        combine(3, 3);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            if ((n - i + 1) >= k) {
                comb(n, i, k, list, result);
            }
        }
        return result;
    }

    public static void comb(int n, int num, int k, List<Integer> list, List<List<Integer>> result) {
        list.add(num);
        if (list.size() == k) {
            result.add(list);
        }
        while (num < n) {
            List<Integer> copyList = new ArrayList<>();
            copyList.addAll(list);
            comb(n, ++num, k, copyList, result);
        }
    }
}
