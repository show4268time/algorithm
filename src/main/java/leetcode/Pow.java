package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: n次方
 * @author: yaoweihao
 * @date: 2018/10/9
 * @time: 18:15
 * @modified by:
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) { return 1.0; }
        if (n == 1) { return x; }
        if (n == -1) { return 1/x; }
        if (n > 0) {
            return (n % 2 == 0)? myPow(x*x,n/2) : x * myPow(x*x,n/2);
        } else { // n<0
            return (n % 2 == 0)? myPow(x*x,n/2) : (1/x) * myPow(x*x,n/2);
        }
    }
}
