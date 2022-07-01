package leetcode.code50;

import java.util.Stack;

/**
 * @author: PhilipFry
 * @create: 2022-07-01 23:22
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Code20IsValid {
    public boolean isValid(String s) {
        Stack<Character> link = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                link.push(c);
            } else {
                if (link.size() == 0) return false;
                char l = link.pop();
                if (!check(l, c)) {
                    return false;
                }
            }
        }
        return link.size() == 0;
    }

    public boolean check(char l, char r) {
        if (l == '(') {
            if (r == ')') return true;
        } else if (l == '[') {
            if (r == ']') return true;
        } else if (l == '{') {
            if (r == '}') return true;
        }
        return false;
    }
}
