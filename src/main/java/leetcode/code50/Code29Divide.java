package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-08-16 23:08
 * @Description:
 */
public class Code29Divide {
    int INF = Integer.MAX_VALUE;

    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;

        boolean neg = false;
        if((x > 0 && y < 0) || (x < 0 && y > 0)) neg = true;
        if(x < 0) x = -x;
        if(y < 0) y = -y;
        long l = 0, r = x;
        while(l < r){
            long mid = l + r + 1 >> 1;
            if(mulit(mid, y) <= x) l = mid;
            else r = mid -1;
        }

        if(neg) l = -l;
        if(l > INF || l < -INF -1) return INF;

        return (int)l;
    }

    private long mulit(long x, long y){
        long res = 0;
        while(y > 0){
            if((y & 1) == 1) res += x;
            y >>= 1;
            x += x;
        }
        return res;
    }
}
