package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 * @author: yaoweihao
 * @date: 2018/11/21
 * @time: 17:13
 * @modified by:
 */
public class Search_2D_Matrix {
    public static void main(String[] args ){
        int[][] matrix = new int[][]{{-8, -5, -3,1},{10, 11, 16, 20}, {23, 30, 34, 50}};
        searchMatrix(matrix, -5);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) { return false; }
        if(matrix[0].length == 0) return false;
        int lineSize = matrix.length;
        int columnSize = matrix[0].length;

        if(matrix[0][0] > target) return  false;
        for(int i = 0; i < lineSize; i ++){
            if(matrix[i][0] == target) return true;
            if((matrix[i][0] < target && matrix[i][columnSize - 1] >= target)){
                return searchArray(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean searchArray(int[] array, int target){
        int length = array.length;
        if(array[length - 1] < target) return false;
        if(array[length - 1] == target) return true;

        int start = 0;
        int end = length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] == target) return true;
            if(array[mid] > target){
                end = mid - 1;
            }else if(array[mid] < target){
                start = mid + 1;
            }
        }
        return false;
    }
}
