package interview;

/**
 * @author: PhilipFry
 * @create: 2022-08-07 18:03
 * @Description: 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 */
public class Interview0805Multiply {

    public int multiply(int A, int B) {
        if (B == 0) return 0;
        if (B == 1) return A;
        if (B == 2) return A + A;
        int n = multiply(A, B / 2);
        if (B % 2 == 0) {
            return n + n;
        } else {
            return n + n + A;
        }
    }
}
