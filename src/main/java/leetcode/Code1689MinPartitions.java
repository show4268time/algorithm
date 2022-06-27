package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-06-27 23:34
 * @Description: A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * <p>
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer,
 * <p>
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 */
public class Code1689MinPartitions {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            int x = n.charAt(i) - '0';
            res = Math.max(x, res);
            if (res == 9) {
                break;
            }
        }
        return res;
    }
}
