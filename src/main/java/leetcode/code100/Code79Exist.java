package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-09-11 17:15
 * @Description: Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */
public class Code79Exist {
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int n, int m) {
        if (index == word.length()) return true;
        if (n < 0 || n > board.length - 1 || m < 0 || m > board[0].length - 1) return false;
        if (used[n][m]) return false;

        if (word.charAt(index) != board[n][m]) return false;
        used[n][m] = true;
        boolean res = dfs(board, word, index + 1, n - 1, m) || dfs(board, word, index + 1, n, m - 1) || dfs(board, word, index + 1, n + 1, m) ||
                dfs(board, word, index + 1, n, m + 1);
        used[n][m] = false;
        return res;
    }

    public static boolean exist1(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        } // 0 x 0 array
        if (board.length == 1 && board[0].length == 1) { // 1 x 1 array
            return (word.length() == 1 && word.charAt(0) == board[0][0]);
        }
        int height = board.length;
        int length = board[0].length;

        char[] chars = word.toCharArray();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (DFS(board, chars, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static Boolean DFS(char[][] board, char[] chars, int i, int j, int num) {
        if (chars.length == num) {
            return true;
        }

        if (board[i][j] != chars[num]) return false;

        board[i][j] = (char) ((int) board[i][j] ^ 256);

        if (i > 0) {
            if (DFS(board, chars, i - 1, j, num + 1))
                return true;
        }

        if (i < board.length - 1) {
            if (DFS(board, chars, i + 1, j, num + 1))
                return true;
        }

        if (j > 0) {
            if (DFS(board, chars, i, j - 1, num + 1))
                return true;
        }

        if (j < board[0].length - 1) {
            if (DFS(board, chars, i, j + 1, num + 1))
                return true;
        }

        board[i][j] = (char) ((int) board[i][j] ^ 256);
        return false;
    }
}
