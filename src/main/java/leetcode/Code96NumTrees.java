package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-17 20:01
 * @Description: Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
public class Code96NumTrees {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return dfs(1, n);
    }

    private int dfs(int index, int n) {
        if (index > n) return 1;
        if (memo[index][n] != 0) {
            return memo[index][n];
        }

        int sum = 0;
        for (int i = index; i <= n; i++) {
            int left = dfs(index, i - 1);
            int right = dfs(i + 1, n);
            sum += left * right;
        }
        memo[index][n] = sum;
        return sum;
    }
}
