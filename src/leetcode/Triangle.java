package leetcode;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * @author: yaoweihao
 * @date: 2019/3/13
 * @time: 13:45
 * @modified by:
 */
public class Triangle {
    public static void main(String[] args) {
//        minimumTotal()
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        return minimumTotal(triangle, 0, 0);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int rowNum, int index) {
        if (rowNum == triangle.size()) return 0;

        int num = triangle.get(rowNum).get(index);
        int count = minimumTotal(triangle, rowNum + 1, index);
        int right = minimumTotal(triangle, rowNum + 1, index + 1);

        return num + Math.min(count, right);
    }

    public static int minimumTotalV1(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = triangle.get(i).get(j);
            }
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
            }
        }

        return matrix[0][0];
    }
}
