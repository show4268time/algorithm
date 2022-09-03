package leetcode.code200;

import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-14 23:06
 * @Description: Given a triangle array, return the minimum (最低) path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent (相邻) number of the row below. More formally (正式) ,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Code120MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == n - 1) {
                    dp[j] = list.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
                }
            }
        }
        return dp[0];
    }
}
