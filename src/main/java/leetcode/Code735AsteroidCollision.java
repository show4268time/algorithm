package leetcode;

import java.util.Stack;

/**
 * @author: PhilipFry
 * @create: 2022-10-08 22:24
 * @Description: We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * <p>
 * Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * <p>
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * <p>
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 * <p>
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 * <p>
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
public class Code735AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (stack.size() > 0 && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                    stack.pop();
                }
                if (stack.size() == 0 || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                }
            }
        }
        if (stack.size() == 0) return new int[0];
        int n = stack.size();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
