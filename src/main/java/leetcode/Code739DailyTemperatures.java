package leetcode;

import java.util.Stack;

/**
 * @author: PhilipFry
 * @create: 2022-07-21 23:26
 * @Description: Given an array of integers temperatures represents the daily temperatures,
 * <p>
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * <p>
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * <p>
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * <p>
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class Code739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
            if (stack.size() > 0) res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
