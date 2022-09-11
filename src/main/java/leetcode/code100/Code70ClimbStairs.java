package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-07-09 14:44
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Code70ClimbStairs {
    public int climbStairs(int n) {
        int m = 1000000007;
        int a = 1, b = 1;
        int res = 0;
        if(n == 0) return a;
        if(n == 1) return b;
        for(int i = 2; i <= n; i++){
            res = (a + b) % m;
            a = b;
            b = res;
        }
        return res;
    }
}
