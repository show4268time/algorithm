package leetcode.code200;

import java.util.Stack;

/**
 * @author: PhilipFry
 * @create: 2022-08-22 22:55
 * @Description: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid.
 * <p>
 * That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * Example 1:  Input: tokens = ["2","1","+","3","*"]
 * <p>
 * Output: 9
 * <p>
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:  Input: tokens = ["4","13","5","/","+"]
 * <p>
 * Output: 6
 * <p>
 * Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:  Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * <p>
 * Output: 22
 * <p>
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 = (0 + 17) + 5 = 17 + 5 = 22
 */
public class Code150EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int n = stack.pop();
                int m = stack.pop();
                stack.push(m + n);
            } else if (tokens[i].equals("-")) {
                int n = stack.pop();
                int m = stack.pop();
                stack.push(m - n);
            } else if (tokens[i].equals("*")) {
                int n = stack.pop();
                int m = stack.pop();
                stack.push(m * n);
            } else if (tokens[i].equals("/")) {
                int n = stack.pop();
                int m = stack.pop();
                stack.push(m / n);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
