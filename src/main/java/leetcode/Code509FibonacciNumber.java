package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-10 18:42
 * @Description: The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
 * starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */
public class Code509FibonacciNumber {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 0;
        int cur = 1;
        int sum = 1;
        for(int i = 2; i <= n; i++){
            sum = pre + cur;
            pre = cur;
            cur = sum;

        }
        return sum;


    }

    private int dp(int n, int[] memo){
        if (n == 0) return 0;
        if (n == 1) return 1;
        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] =  dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }
}
