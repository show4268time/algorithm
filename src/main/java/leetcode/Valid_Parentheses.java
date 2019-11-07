package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最长合法括号
 * @author: yaoweihao
 * @date: 2018/9/6
 * @time: 9:52
 * @modified by:
 */
public class Valid_Parentheses {
    public static void main(String[] args){
        String s = "()[]{}";
        isValid(s);
    }

    /**
     * 把符号分为左边符{[(和右边符)]}两组。
     * 遇到{[(就把他们存到Stack里，遇到)]}就peek出当前处于最上面的一个左边符，检查是否匹配
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s.equals("")) return true;

        char[] c = s.toCharArray();
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('(', ')');
        characterMap.put('[', ']');
        characterMap.put('{', '}');

        if(c.length % 2 != 0) return false;

        //Stack用Deque接口的LinkedList
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < c.length; i++){
            if(characterMap.containsKey(c[i])){
                stack.push(c[i]);
                continue;
            }
            if(characterMap.containsValue(c[i])){
                Character top = stack.peek();
                if(top == null){
                    return false;
                }else {
                    if(characterMap.get(top) == c[i]){
                        stack.pop();
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        if(stack.size() == 0) return true;
        return false;
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(')');
            else if(s.charAt(i) == '[') stack.push(']');
            else if(s.charAt(i) == '{') stack.push('}');
            else{
                if(stack.isEmpty()) return false;
                else if(stack.pop() != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }
}
