package leetcode;

import java.util.Stack;

/**
 * @author: PhilipFry
 * @create: 2022-07-21 23:26
 * @Description: 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class Code739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
