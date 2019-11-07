package leetcode;


/**
 * Created with IntelliJ IDEA
 *
 * @description: 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @author: yaoweihao
 * @date: 2018/10/25
 * @time: 10:50
 * @modified by:
 */
public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        return getPaths(0, 0, m, n, memo);
    }

    public int getPaths(int longth, int heigh, int m, int n, int[][] memo){
        if(memo[longth][heigh] != 0) return memo[longth][heigh];
        if(longth == m - 1 && heigh == n - 1){
            memo[m - 1][n - 1] = 1;
            return 1;
        }

        int rightCount = 0, downCount = 0;
        if(longth < m - 1){
            rightCount = getPaths(longth +1, heigh, m, n, memo);
        }

        if(heigh < n - 1){
            downCount = getPaths(longth, heigh + 1, m, n, memo);
        }
        memo[longth][heigh] = rightCount + downCount;
        return memo[longth][heigh];
    }
}
