package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-09-11 23:49
 * @Description: Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Code50MyPow {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
