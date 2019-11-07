package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 能盛最多水
 * @author: yaoweihao
 * @date: 2018/9/13
 * @time: 9:34
 * @modified by:
 */
public class P11_Container_With_Most_Water {
    /**
     * 普通解法，双循环，但是效率很低
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int n = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(n, max);
            }
        }
        return max;
    }

    /**
     * 这题最有效的解法，思路也是类似“动态规划”的维护当前最优解。
     * 可以先计算相距最远的两个线段盛水的面积。
     * 哪边线段短，就往前推进一格。
     * 比较新构成的面积和之前维护的最大面积，只保留较大值。直到两条线段重合。
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int n = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(n, max);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
