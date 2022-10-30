package leetcode.code200;

import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-14 23:06
 * @Description: Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 * <p>
 * Input: triangle = [[-10]]
 * Output: -10
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
