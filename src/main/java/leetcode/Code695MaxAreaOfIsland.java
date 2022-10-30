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
    int w = 0;
    int h = 0;
    int[][] g;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        h = m;
        w = n;
        g = grid;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                res = Math.max(res, dfs(i, j));
            }
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i == h) return 0;
        if (j < 0 || j == w) return 0;
        if (g[i][j] != 1) return 0;
        g[i][j] = -1;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1) + dfs(i - 1, j) + dfs(i, j - 1);
    }
}
