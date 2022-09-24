package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-24 21:47
 * @Description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class Offer13MovingCount {
    boolean[][] used;
    int result = 0;
    int c = 0;

    public int movingCount(int m, int n, int k) {
        used = new boolean[m][n];
        c = k;
        dfs(m, n, 0, 0);
        return result;
    }

    private void dfs(int m, int n, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) return;

        if (used[i][j]) return;
        used[i][j] = true;

        boolean k = convert(i) + convert(j) > c;
        if (!k) result++;

        if (!k) dfs(m, n, i + 1, j);
        if (!k) dfs(m, n, i, j + 1);
        dfs(m, n, i - 1, j);
        dfs(m, n, i, j - 1);
    }

    private int convert(int number) {
        int res = 0;
        while (number > 0) {
            res += number % 10;
            number = number / 10;
        }
        return res;
    }
}
