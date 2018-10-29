package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @author: yaoweihao
 * @date: 2018/10/25
 * @time: 13:51
 * @modified by:
 */
public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int longth = obstacleGrid.length;
        if(longth == 0) return 0;
        int heigh = obstacleGrid[0].length;
        if(heigh == 0) return 0;
        int[][] memo = new int[longth][heigh];


        return getPaths(0, 0, longth, heigh, obstacleGrid, memo);
    }

    public int getPaths(int longth, int heigh, int m, int n, int[][] obstacleGrid, int[][] memo) {
        if(obstacleGrid[longth][heigh] == 1) return 0;
        if (memo[longth][heigh] != 0) return memo[longth][heigh];
        if (longth == m - 1 && heigh == n - 1) {
            memo[m - 1][n - 1] = 1;
            return 1;
        }

        int rightCount = 0, downCount = 0;
        if (longth < m - 1 && obstacleGrid[longth + 1][heigh] == 0) {
            rightCount = getPaths(longth + 1, heigh, m, n, obstacleGrid, memo);
        }

        if (heigh < n - 1 && obstacleGrid[longth][heigh + 1] == 0) {
            downCount = getPaths(longth, heigh + 1, m, n, obstacleGrid, memo);
        }
        memo[longth][heigh] = rightCount + downCount;
        return memo[longth][heigh];
    }
}
