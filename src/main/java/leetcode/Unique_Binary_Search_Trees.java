package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @author: yaoweihao
 * @date: 2019/1/17
 * @time: 13:07
 * @modified by:
 */
public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i <= n; i++){
            dp[i] = 0;
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
