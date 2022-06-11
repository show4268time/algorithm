package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-11 10:12
 * @Description: Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class Code279NumSquares {
    int INF = 0x3f3f3f3f;

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int s = 1;
        while (s * s <= n) {
            list.add(s * s);
            s++;
        }
        int length = list.size();
        int[][] dp = new int[length + 1][n + 1];

        Arrays.fill(dp[0], INF);

        dp[0][0] = 0;

        for (int i = 1; i <= length; i++) {
            int num = list.get(i - 1);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (num <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - num] + 1);
                }
            }
        }

        return dp[length][n];
    }
}
