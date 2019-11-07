package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * @author: yaoweihao
 * @date: 2019/4/4
 * @time: 9:49
 * @modified by:
 */
public class Gas_Station {

    public static void main(String[] args) {
        int[] gas = new int[]{3, 3, 4};
        int[] cost = new int[]{3, 4, 4};
        canCompleteCircuit(gas, cost);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        for (int cur = 0; cur < length; cur++) {
            int road = length;
            int ga = gas[cur];
            int temp = cur;
            while (road > 0 && ga > 0) {
                if (ga >= cost[temp % length]) {
                    ga = ga - cost[temp % length] + gas[(temp + 1) % length];
                } else {
                    cur = temp;
                    break;
                }
                road--;
                temp++;
            }
            if (road == 0) {
                return cur;
            }
        }
        return -1;
    }
}
