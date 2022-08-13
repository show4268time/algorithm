package leetcode.code100;

import java.util.Stack;

/**
 * @author: PhilipFry
 * @create: 2022-08-13 15:05
 * @Description: Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class Code67AddBinary {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> aStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();

        for (int i = 0; i < ac.length; i++) {
            aStack.push(ac[i]);
        }

        for (int i = 0; i < bc.length; i++) {
            bStack.push(bc[i]);
        }
        int pre = 0;
        while (aStack.size() > 0 || bStack.size() > 0 || pre > 0) {
            int n = 0;
            if (aStack.size() > 0) n += aStack.pop() - '0';
            if (bStack.size() > 0) n += bStack.pop() - '0';
            n += pre;
            sb.insert(0, n % 2);
            pre = n / 2;
        }

        return sb.toString();
    }
}
