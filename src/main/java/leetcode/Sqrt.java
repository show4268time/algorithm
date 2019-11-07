package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @author: yaoweihao
 * @date: 2018/11/3
 * @time: 14:22
 * @modified by:
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 0) { return 0; }
        return recursive(x,1,x);
    }
    public int recursive(int x, int lo, int hi) {
        if (lo == hi) { return lo; }
        int mid = lo + ( (hi - lo + 1) / 2);
        long product = (long)mid * mid;
        if (product > (long)x) {
            return recursive(x,lo,mid-1);
        } else if (product < (long)x) {
            return recursive(x,mid,hi);
        } else {
            return mid;
        }
    }
}
