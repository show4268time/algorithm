package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 字符串转数字(Atoi)
 * @author: yaoweihao
 * @date: 2018/9/12
 * @time: 9:41
 * @modified by:
 */
public class String_to_Integer {

    public static void main(String[] args) {
        String str = "42";
        myAtoi(str);
    }

    private static final Map<Character, Integer> DICTIONARY = new HashMap<>();

    static {
        DICTIONARY.put('0', 0);
        DICTIONARY.put('1', 1);
        DICTIONARY.put('2', 2);
        DICTIONARY.put('3', 3);
        DICTIONARY.put('4', 4);
        DICTIONARY.put('5', 5);
        DICTIONARY.put('6', 6);
        DICTIONARY.put('7', 7);
        DICTIONARY.put('8', 8);
        DICTIONARY.put('9', 9);
    }

    public static int myAtoi(String str) {
        boolean is = false;
        boolean b = false;
        long n = 0L;
        str = str.trim();
        if (str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        if (chars.length == 1) {
            char c = chars[0];
            if (Character.isDigit(c)) {
                return DICTIONARY.get(c);
            } else {
                return 0;
            }
        } else {
            char c = chars[0];
            if (c == '-') {
                is = true;
                b = true;
            } else if (c == '+') {
                b = true;
            } else if (!Character.isDigit(c)) {
                return 0;
            }
            int i = 0;
            if (is || b) i++;
            int signum = is ? -1 : 1;
            for (int j = i; j < chars.length; j++) {
                if (Character.isDigit(chars[j])) {
                    n = n * 10 + DICTIONARY.get(chars[j]) * signum;
                    if (n > 0 && n > (long) Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (n < 0 && n < (long) Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        }
        return (int) n;
    }
}
