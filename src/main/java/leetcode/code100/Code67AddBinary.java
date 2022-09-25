package leetcode.code100;

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
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int la = ca.length;
        int lb = cb.length;

        int mod = 0;
        StringBuilder sb = new StringBuilder();
        while (la > 0 || lb > 0 || mod > 0) {
            int n = (la > 0 ? ca[la - 1] - '0' : 0) + (lb > 0 ? cb[lb - 1] - '0' : 0) + mod;
            sb.insert(0, n % 2);
            mod = n / 2;
            la--;
            lb--;
        }
        return sb.toString();
    }
}
