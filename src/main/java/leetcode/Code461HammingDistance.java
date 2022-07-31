package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-31 16:58
 * @Description: The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 */
public class Code461HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z > 0) {
            res += z & 1;
            z = z >> 1;
        }
        return res;
    }
}
