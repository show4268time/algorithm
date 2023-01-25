package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2023-01-25 14:41
 * @Description: n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
public class Code52TotalNQueens {
    static int n = 10;
    boolean[] col = new boolean[n];
    boolean[] dg = new boolean[n * 2];
    boolean[] udg = new boolean[n * 2];

    public int totalNQueens(int _n) {
        n = _n;
        col = new boolean[n];
        dg = new boolean[n * 2];
        udg = new boolean[n * 2];
        return dfs(0);
    }

    private int dfs(int l) {
        if (l == n) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[i + l] && !udg[i - l + n]) {
                col[i] = dg[i + l] = udg[i - l + n] = true;
                res += dfs(l + 1);
                col[i] = dg[i + l] = udg[i - l + n] = false;
            }
        }
        return res;
    }
}
