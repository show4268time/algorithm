package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-06-14 23:50
 * @Description: You are given an integer array height of length n.
 * There are n vertical (垂直) lines drawn such that the two endpoints (端点) of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container , such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant (斜) the container .
 */
public class Code11MaxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int res = 0;
        while (i < j) {
            int num = height[i] > height[j] ? height[j] : height[i];
            res = Math.max(res, (j - i) * num);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
