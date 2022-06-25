package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-06-18 14:57
 * @Description: Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Code74SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int n = 0;
        while (n + 1 < matrix.length) {
            if (matrix[n][0] <= target && matrix[n + 1][0] > target) {
                break;
            }
            n++;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[n][i] == target) {
                return true;
            }
        }
        return res;
    }
}
