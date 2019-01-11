package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description:
 * @author: yaoweihao
 * @date: 2019/1/10
 * @time: 14:33
 * @modified by:
 */
public class Matrix {
    public Integer solution(int[][] matrix){

        int height = matrix.length;
        int longth = matrix[0].length;
        int num = 0;
        for(int i = 0; i < height; i++){
            for (int j = 0; j < longth; j++){
                if(matrix[i][j] == 1){
                    if(BFS(height, longth, i, j, matrix)){
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public Boolean BFS(int height, int longth, int x , int y, int[][] matrix){
        Boolean isTrue = false;
        if(x + 1 < height){
            if(matrix[x + 1][y] == 1){
                isTrue = true;
                matrix[x + 1][y] = 0;
                BFS(height, longth, x + 1 , y,  matrix);
            }
        }

        if(x - 1 >= 0){
            if(matrix[x - 1][y] == 1){
                isTrue = true;
                matrix[x - 1][y] = 0;
                BFS(height, longth, x - 1 , y,  matrix);
            }
        }

        if(y + 1 < longth){
            if(matrix[x ][y + 1] == 1){
                isTrue = true;
                matrix[x ][y + 1] = 0;
                BFS(height, longth, x   , y + 1,  matrix);
            }
        }

        if(y - 1 >= 0){
            if(matrix[x ][y - 1] == 1){
                isTrue = true;
                matrix[x ][y -1] = 0;
                BFS(height, longth, x   , y - 1,  matrix);
            }
        }
        return isTrue;
    }
}
