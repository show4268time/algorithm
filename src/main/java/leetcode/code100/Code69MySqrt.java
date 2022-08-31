package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-08-31 19:36
 * @Description: Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class Code69MySqrt {
    public int mySqrt(int x) {
        long n = x;
        long l = 0l, r = n;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= x) l = mid;
            else r = mid - 1;
        }
        return (int) l;
    }
}
