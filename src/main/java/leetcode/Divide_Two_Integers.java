package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 两数相除
 * @author: yaoweihao
 * @date: 2018/9/20
 * @time: 13:50
 * @modified by:
 */
public class Divide_Two_Integers {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        divide(dividend, divisor);
    }

    public static int divide(int dividend, int divisor) {
        // edge case
        if (divisor == 0) { return Integer.MAX_VALUE; } // 0不能当除数
        if (dividend == Integer.MIN_VALUE && divisor == -1) { return Integer.MAX_VALUE; } // int不能表示2147483648
        if (dividend == 0) { return 0; } // 0除以任何数等于0
        // treat sign
        int sign = (Integer.signum(dividend)== Integer.signum(divisor))? 1:-1; // get the sign
        // division
        int result = 0;
        long dividendL = Math.abs((long)dividend), divisorL = Math.abs((long)divisor);
        while (dividendL >= divisorL) {
            int shift = 1;
            while (dividendL >= (divisorL << shift)) { shift++; }
            result += 1 << (shift-1);
            dividendL -= (divisorL << shift-1);
        }
        return (sign == 1)? result : -result;
    }
}
