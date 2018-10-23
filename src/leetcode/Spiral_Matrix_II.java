package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 螺旋矩阵 II
 * 分别记住左边界left,右边界right,上边界high,下边界low。然后把一个圈分成下面四部分填写
 * @author: yaoweihao
 * @date: 2018/10/22
 * @time: 16:27
 * @modified by:
 */
public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] reslut = new int[n][n];
        int left = 0, right = n-1, high = 0, low = n-1;
        int next = 0;
        for (; n > 0; n-=2, left++, right--, high++, low--) {
            if (right == left && low == high) { reslut[left][high] = ++next; }
            for (int i = left; i < right; i++) {
                reslut[high][i] = ++next;
            }
            for (int i = high; i < low; i++) {
                reslut[i][right] = ++next;
            }
            for (int i = right; i > left; i--) {
                reslut[low][i] = ++next;
            }
            for (int i = low; i > high; i--) {
                reslut[i][left] = ++next;
            }
        }
        return reslut;
    }
}
