package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 罗马数字转阿拉伯数字
 * @author: yaoweihao
 * @date: 2018/9/4
 * @time: 20:26
 * @modified by:
 */
public class Roman_to_Integer {
    public int romanToInt(String s) {
        int sum = 0;
        int[] nums = new int[s.length()];
        char[] roman = s.toCharArray();
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);
        for (int i = 0; i < s.length(); i++) {
            nums[i] = romanMap.get(roman[i]);
        }

        //如果左边的值小于右边的，表明这个数应该被减去
        for (int i = 0; i < s.length() - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        sum += nums[s.length() - 1];
        return sum;
    }
}
