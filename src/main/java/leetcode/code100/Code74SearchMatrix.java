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

    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = m * n -1;
        while(l < r){
            int mid = l + r >> 1;
            if(matrix[mid / m][mid % m] >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }

        return matrix[r / m][r % m] == target;
    }
}
