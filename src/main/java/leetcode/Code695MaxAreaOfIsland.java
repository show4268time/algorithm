package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-09-04 09:09
 * @Description: You are given an m x n binary matrix grid.
 * <p>
 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * <p>
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class Code695MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) res = Math.max(res, dfs(grid, i, j));

            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int cur = 1;
        cur += dfs(grid, i - 1, j);
        cur += dfs(grid, i + 1, j);
        cur += dfs(grid, i, j - 1);
        cur += dfs(grid, i, j + 1);
        return cur;
    }
}
