package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 阿拉伯数字转罗马数字
 * @author: yaoweihao
 * @date: 2018/9/13
 * @time: 20:18
 * @modified by:
 */
public class Integer_to_Roman {
    public String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digit=0;
        while (num > 0) {
            int times = num / nums[digit];
            num -= nums[digit] * times;
            for ( ; times > 0; times--) {
                res.append(symbols[digit]);
            }
            digit++;
        }
        return res.toString();
    }
}
