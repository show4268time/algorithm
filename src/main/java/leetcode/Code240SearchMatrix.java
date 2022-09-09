package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-29 22:49
 * @Description: Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class Code240SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0, m = matrix[0].length - 1;
        while (n < matrix.length && m >= 0) {
            if (matrix[n][m] > target) {
                m--;
            } else if (matrix[n][m] < target) {
                n++;
            } else {
                return true;
            }
        }
        return false;
    }
}
