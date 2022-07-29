package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-29 22:49
 * @Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * <p>
 * 每列的元素从上到下升序排列。
 */
public class Code240SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
