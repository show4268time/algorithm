package weeklyContest.BiweeklyContest79;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-29 07:50
 * @Description: You are given a 0-indexed string num of length n consisting of digits.
 * Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num, otherwise return false.
 */
public class Contest2283DigitCount {
    public boolean digitCount(String num) {
        int[] count = new int[num.length()];
        Arrays.fill(count, 0);
        char[] chars = num.toCharArray();
        for (char c : chars) {
            int i = c - '0';
            if (i < chars.length) {
                count[c - '0']++;
            }
        }
        for (int i = 0; i < num.length(); i++) {
            if (chars[i] - '0' != count[i]) {
                return false;
            }
        }
        return true;
    }
}
