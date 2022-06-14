package leetcode.code150;

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
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == n - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }
}
