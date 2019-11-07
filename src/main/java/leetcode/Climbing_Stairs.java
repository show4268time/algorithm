package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author: showtime
 * @create: 2018-11-06 21:56
 **/
public class Climbing_Stairs {
    public int climbStairs(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        return climb(n, 0, map);
    }

    public int climb(int n, int climbNum, Map<Integer, Integer> map){
        if(map.get(climbNum) != null){
            return map.get(climbNum);
        }
        if(n == climbNum){
            map.put(climbNum, 1);
            return 1;
        }
        int numO = 0;
        int numT = 0;
        if(climbNum <= n -2){
            numO = climb(n, climbNum + 1, map);
            numT = climb(n, climbNum + 2, map);
        }else {
            numO = climb(n, climbNum + 1, map);
        }
        map.put(climbNum, numO + numT);
        return numO + numT;
    }
}
