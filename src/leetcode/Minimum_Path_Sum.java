package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步
 * @author: yaoweihao
 * @date: 2018/10/29
 * @time: 17:55
 * @modified by:
 */
public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(grid);
    }

    public static int minPathSum(int[][] grid) {
        int heigh = grid.length;
        if(heigh == 0) return 0;
        int length = grid[0].length;
        if(length == 0) return 0;
        int[][] temp = new int[heigh][length];

        for (int l = length - 1; l >= 0; l--) {
            for (int h = heigh - 1; h >= 0; h--) {
                int i = 0;
                int n = 0;
                if (l == length - 1 && h == heigh - 1) {

                } else if (l != length - 1 && h == heigh - 1) {
                    i = temp[h][l + 1];
                    n = Integer.MAX_VALUE;
                } else if (h != heigh - 1 && l == length - 1) {
                    n = temp[h + 1][l];
                    i = Integer.MAX_VALUE;
                } else {
                    i = temp[h][l + 1];
                    n = temp[h + 1][l];
                }

                temp[h][l] = grid[h][l] + Math.min(i, n);
            }
        }
        return temp[0][0];
    }
}
