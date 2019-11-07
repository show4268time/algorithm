package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 螺旋矩阵
 * @author: yaoweihao
 * @date: 2018/10/11
 * @time: 9:52
 * @modified by:
 */
public class Spiral_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{6, 9, 7}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1, high = 0, low = matrix.length - 1;

        for (int n = matrix[0].length, m = matrix.length; n > 0 && m > 0; left++, right--, high++, low--, n -= 2, m -= 2) {

            for (int i = left; i < right; i++) {
                result.add(matrix[high][i]);
            }

            for (int i = high; i < low; i++) {
                result.add(matrix[i][right]);
            }

            if (low - high > 0) {
                for (int i = right; i > left; i--) {
                    result.add(matrix[low][i]);
                }
            } else { // 横一字长条
                result.add(matrix[high][right]);
            }

            if (right - left > 0) {
                for (int i = low; i > high; i--) {
                    result.add(matrix[i][left]);
                }
            } else if (low - high > 0) { // 纵向一字长条，且不是单个点
                result.add(matrix[low][left]);
            }
        }
        return result;
    }
}
