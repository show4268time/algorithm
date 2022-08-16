package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-08-16 23:08
 * @Description: Given two integers dividend and divisor, divide two integers without using multiplication,
 * <p>
 * division, and mod operator.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example,
 * <p>
 * 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed
 * <p>
 * integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
 * <p>
 * and if the quotient is strictly less than -231, then return -231.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 */
public class Code29Divide {
    int INF = Integer.MAX_VALUE;

    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;

        boolean neg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) neg = true;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long l = 0, r = x;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mulit(mid, y) <= x) l = mid;
            else r = mid - 1;
        }

        if (neg) l = -l;
        if (l > INF || l < -INF - 1) return INF;

        return (int) l;
    }

    private long mulit(long x, long y) {
        long res = 0;
        while (y > 0) {
            if ((y & 1) == 1) res += x;
            y >>= 1;
            x += x;
        }
        return res;
    }
}
