package leetcode;

/**
 * @program: algorithm
 * @description: 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @author: showtime
 * @create: 2018-10-27 14:43
 **/
public class Unique_Paths_II {
    public static void main(String[] args){
        int[][] obstacleGrid = new int[][]{{1,2,3,4}};
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lineSize = obstacleGrid.length;
        if (lineSize == 0) {
            return 0;
        }
        int columnSize = obstacleGrid[0].length;
        if (columnSize == 0) {
            return 0;
        }
        int[][] memo = new int[lineSize][columnSize];
        for (int i = lineSize - 1; i >= 0; i--) {
            for (int j = columnSize - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                    continue;
                }
                if ((i == lineSize - 1) && (j == columnSize - 1)) {
                    memo[i][j] = 1;
                    continue;
                }
                if (i == lineSize - 1) {
                    memo[i][j] = memo[i][j + 1];
                    continue;
                }
                if (j == columnSize - 1) {
                    memo[i][j] = memo[i + 1][j];
                    continue;
                }
                memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
            }
        }
        return memo[0][0];
    }
}
