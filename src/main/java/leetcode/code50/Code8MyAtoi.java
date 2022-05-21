package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-05-06 10:46
 * @Description: Implement the myAtoi(string s) function,
 * which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 */
public class Code8MyAtoi {
    public int myAtoi(String str) {
        int sign = 1, base = 0, i = 0, INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i >= str.length()) return 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i++) - '0';

            if (base > INT_MAX / 10 || (base == INT_MAX / 10 && digit > INT_MAX % 10)) {
                if (sign == 1) {
                    return INT_MAX;
                } else {
                    return INT_MIN;
                }
            }
            base = base * 10 + digit;
        }

        return base * sign;
    }
}
