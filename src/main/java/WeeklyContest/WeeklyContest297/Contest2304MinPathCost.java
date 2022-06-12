package WeeklyContest.WeeklyContest297;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-06-12 12:45
 * @Description:You are given a 0- indexed (指数) m x n integer matrix (矩阵) grid consisting of distinct (鲜明) integers from 0 to m * n - 1. You can move in this matrix (矩阵) from a cell to any other cell in the next row. That is, if you are in cell (x, y) such that x < m - 1, you can move to any of the cells (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1). Note that it is not possible to move from cells in the last row.
 * <p>
 * Each possible move has a cost given by a 0- indexed (指数) 2D array moveCost of size (m * n) x n, where moveCost[i][j] is the cost of moving from a cell with value i to a cell in column j of the next row. The cost of moving from cells in the last row of grid can be ignored.
 * <p>
 * The cost of a path in grid is the sum of all values of cells visited plus the sum of costs of all the moves made. Return the minimum (最低) cost of a path that starts from any cell in the first row and ends at any cell in the last row.
 */
public class Contest2304MinPathCost {
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int h = grid.length;
        int w = grid[0].length;

        int[][] dp = new int[h + 1][w + 1];
        for (int i = 0; i < w; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < h; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < w; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < w; i++) {
            res = Math.min(res, dp[h - 1][i]);
        }
        return res;
    }
}
