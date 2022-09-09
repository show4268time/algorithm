package offer.special;

/**
 * @author: PhilipFry
 * @create: 2022-08-13 17:00
 * @Description: 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 * <p>
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 * <p>
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：a = 1, b = 1
 * 输出：1
 */
public class Offer001Divide {
    public int divide(int a, int b) {
        if (a == 0) return 0;
        boolean neg = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) neg = true;

        long x = a, y = b;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long left = 0, right = x;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (multi(mid, y) <= x) left = mid;
            else right = mid - 1;
        }
        long res = neg ? -left : left;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

    private long multi(long a, long b) {
        long res = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res += a;
            }
            b >>= 1;
            a += a;
        }
        return res;
    }
}
