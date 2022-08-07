package interview;

/**
 * @author: PhilipFry
 * @create: 2022-08-07 09:47
 * @Description: 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 */
public class Interview0801WaysToStep {
    public int waysToStep(int n) {
        int m = 1000000007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % m + dp[i - 3]) % m;
        }
        return dp[n];
    }
}
