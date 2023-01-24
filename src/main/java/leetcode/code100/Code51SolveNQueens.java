package leetcode.code100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2023-01-24 23:02
 * @Description:
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Code51SolveNQueens {
    List<List<String>> result = new ArrayList<>();
    static int n = 10;
    boolean[] col = new boolean[n];
    boolean[] dg = new boolean[n];
    boolean[] udg = new boolean[n * 2];
    char[][] chars = new char[n][n];

    public List<List<String>> solveNQueens(int _n) {
        n = _n;
        col = new boolean[n];
        dg = new boolean[n * 2];
        udg = new boolean[n * 2];
        chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        dfs(0);
        return result;
    }

    private void dfs(int p) {
        if (p == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String temp = "";
                for (int j = 0; j < n; j++) {
                    temp += chars[i][j];
                }
                list.add(temp);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[i + p] && !udg[i - p + n]) {
                col[i] = dg[i + p] = udg[i - p + n] = true;
                chars[p][i] = 'Q';
                dfs(p + 1);
                col[i] = dg[i + p] = udg[i - p + n] = false;
                chars[p][i] = '.';
            }
        }
    }
}
