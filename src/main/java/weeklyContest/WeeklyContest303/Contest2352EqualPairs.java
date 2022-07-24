package weeklyContest.WeeklyContest303;

/**
 * @author: PhilipFry
 * @create: 2022-07-24 13:42
 * @Description: Given a 0-indexed n x n integer matrix grid, return the number of pairs (Ri, Cj) such that row Ri and column Cj are equal.
 * <p>
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e. an equal array).
 */
public class Contest2352EqualPairs {
    public int equalPairs(int[][] grid) {
        int res = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                while (k < n) {
                    if (grid[i][k] != grid[k][j]) {
                        break;
                    }
                    if (k == n - 1) {
                        res++;
                    }
                    k++;
                }
            }
        }
        return res;
    }
}
