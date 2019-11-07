package leetcode;


/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用
 * @author: yaoweihao
 * @date: 2018/12/6
 * @time: 10:47
 * @modified by:
 */
public class Word_Search {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        exist(board, "ABCCED");
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) { return false; } // 0 x 0 array
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
