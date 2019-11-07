package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @author: yaoweihao
 * @date: 2019/3/12
 * @time: 21:27
 * @modified by:
 */
public class Pascal_Triangle {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int n = 1;
        while (n <= numRows) {
            List<Integer> list = new ArrayList<>(n);
            List<Integer> preList = n >= 3 ? result.get(n - 2) : new ArrayList<>(n);
            list.add(0, 1);
            if (n > 1) list.add(list.size() - 1, 1);
            for (int i = 1; i < n - 1; i++) {
                int res = preList.get(i - 1) + preList.get(i);
                list.add(i, res);
            }
            result.add(list);
            n++;
        }
        return result;
    }
}
