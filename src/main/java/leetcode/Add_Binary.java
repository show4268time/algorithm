package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0
 * @author: yaoweihao
 * @date: 2018/10/30
 * @time: 15:30
 * @modified by:
 */
public class Add_Binary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        addBinary(a, b);
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int plus = 0;
        int lengtha = a.length();
        int lengthb = b.length();
        int length = Math.max(lengtha, lengthb);
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();

        for (int i = 0; i < length; i++) {
            int n = 0;
            int m = 0;
            if (i <= lengtha - 1) {
                n = chara[lengtha - 1 - i] - '0';
            }
            if (i <= lengthb - 1) {
                m = charb[lengthb - 1 - i] - '0';
            }

            int num = n + m + plus;
            sb.insert(0, num % 2);
            plus = num / 2;
        }

        if (plus != 0) {
            sb.insert(0, plus);
        }
        return sb.toString();
    }
}
