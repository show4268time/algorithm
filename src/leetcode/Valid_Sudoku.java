package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 有效的数独
 * @author: yaoweihao
 * @date: 2018/9/30
 * @time: 13:53
 * @modified by:
 */
public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        if (! checkLine(board)) { return false; }
        if (! checkColumn(board)) { return false; }
        if (! checkSubBox(board)) { return false; }
        return true;
    }

    public boolean checkLine(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int bitMap = 0;
            for (int j = 0; j < 9; j++) {
                bitMap = checkBitMap(bitMap, board[i][j]);
                if(bitMap == Integer.MAX_VALUE){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] board) {
        for(int j = 0; j < 9; j++){
            int bitMap = 0;
            for(int i = 0; i < 9; i++){
                bitMap = checkBitMap(bitMap, board[i][j]);
                if(bitMap == Integer.MAX_VALUE){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSubBox(char[][] board){
        for (int i = 0; i < 3; i++) { // loop line
            for (int j = 0; j < 3; j++) { // loop column
                if (! checkThreeThreeBox(board,i*3,j*3)) { return false; }
            }
        }
        return true;
    }

    public boolean checkThreeThreeBox(char[][] board, int startHeight, int startWidth) {
        int bitMap = 0;
        for (int i = startHeight; i < startHeight+3; i++) { // loop line
            for (int j = startWidth; j < startWidth+3; j++) { // loop column
                bitMap = checkBitMap(bitMap,board[i][j]);
                if (bitMap == Integer.MAX_VALUE) { return false; }
            }
        }
        return true;
    }

    public int checkBitMap(int bitMap, char c) {
        //转换成数字
        int num = c - '0';

        if(num > 0 && num <= 9){
            int mask = 1 << (num - 1);

            if ((bitMap & mask) == mask) {
                return Integer.MAX_VALUE;
            } else {
                return (bitMap | mask);
            }
        }
        return bitMap;
    }
}
