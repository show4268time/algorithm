package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * @author: yaoweihao
 * @date: 2018/11/21
 * @time: 16:09
 * @modified by:
 */
public class Set_Matrix_Zeroes {
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        int lineSize = matrix.length;
        if (lineSize == 0) { return; }
        int columnSize = matrix[0].length;
        List<Integer> zeroLine = new ArrayList<>();
        List<Integer> zeroColumn = new ArrayList<>();

        for(int i = 0; i < lineSize; i++){
            for(int j = 0; j < columnSize; j++){
                if(matrix[i][j] == 0){
                    zeroLine.add(i);
                    zeroColumn.add(j);
                }
            }
        }

        for(Integer line : zeroLine){
            for(int i = 0; i < columnSize; i ++){
                matrix[line][i] = 0;
            }
        }

        for(Integer column : zeroColumn){
            for(int i = 0; i < lineSize; i++){
                matrix[i][column] = 0;
            }
        }
    }
}
