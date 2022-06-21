package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-06-21 23:19
 * @Description: You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 */
public class Code474FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            String str = strs[k];
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int k = 1; k <= strs.length; k++) {
            String str = strs[k - 1];
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (i >= zero && j >= one) {
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i - zero][j - one] + 1);
                    }
                }
            }

        }
        return dp[length][m][n];
    }
}
