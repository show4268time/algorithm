package weeklyContest.WeeklyContest299;

/**
 * @author: PhilipFry
 * @create: 2022-06-26 13:26
 * @Description: A square matrix is said to be an X-Matrix if both of the following conditions hold:
 * <p>
 * All the elements in the diagonals of the matrix are non-zero.
 * All other elements are 0.
 * Given a 2D integer array grid of size n x n representing a square matrix, return true if grid is an X-Matrix. Otherwise, return false.
 */
public class Contest2319CheckXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        int start = 0, end = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == start || j == end) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
            start++;
            end--;
        }
        return true;
    }
}
