package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 锯齿形转换
 * @author: yaoweihao
 * @date: 2018/9/11
 * @time: 15:25
 * @modified by:
 */
public class ZigZag_Conversion {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 4;
        convert(s, numRows);
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) { return s; }
        char[] chars = s.toCharArray();
        char[][] matrix = new char[numRows][chars.length];
        int[] cursors = new int[numRows];
        boolean goesUp = false; // 控制掉头，0=down, 1=up
        for (int i = 0, row = 0; i < chars.length; i++){
            matrix[row][cursors[row]++] = chars[i];
            // 掉头
            if (row == 0) { goesUp = false; }
            if (row == numRows-1) { goesUp = true; }
            // 跑
            row = (goesUp)? row-1 : row+1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(matrix[i],0,cursors[i]);
        }
        return sb.toString();
    }
}
