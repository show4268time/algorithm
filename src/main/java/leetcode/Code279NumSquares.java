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
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i);
        }

        int m = list.size();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 0x3f3f3f3f);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int x = i * i;
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * x <= j; k++) {
                    if (dp[i - 1][j - k * x] != 0x3f3f3f3f) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * x] + k);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public int numSquares1(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i);
        }

        int m = list.size();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 0x3f3f3f3f);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int x = i * i;
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= x) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - x] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int numSquares2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i);
        }

        int m = list.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            int x = i * i;
            for (int j = x; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[n];
    }
}
