package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 解码方法
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example, Given encoded message 12, it could be decoded as AB (1 2) or L (12).
 * The number of ways decoding 12 is 2.
 * @author: yaoweihao
 * @date: 2018/12/17
 * @time: 9:13
 * @modified by:
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        if(s.length() == 0 ) return 0;
        char[] chars = s.toCharArray();
        int[] memo = new int[chars.length + 1];
        Arrays.fill(memo, -1);
        memo[chars.length] = 1;
        return decoding(chars, 0, memo);
    }

    private int decoding(char[] chars, int cur, int[] memo) {
        Integer res = memo[cur];
        if (res != -1) return res;

        if (chars[cur] == '0') {
            memo[cur] = 0;
            return 0;
        }

        res = decoding(chars, cur + 1, memo);
        if (cur + 1 < chars.length && (chars[cur] == '1' || (chars[cur] == '2' && chars[cur + 1] <= '6'))) {
            res = res + decoding(chars, cur + 2, memo);
        }
        memo[cur] = res;
        return res;
    }
}
