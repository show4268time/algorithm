package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-05-06 10:29
 * @Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 */
public class Code6ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[][] matrix = new char[numRows][chars.length];
        int[] cursors = new int[numRows];
        boolean goesUp = false; // 控制掉头，0=down, 1=up
        for (int i = 0, row = 0; i < chars.length; i++) {
            matrix[row][cursors[row]++] = chars[i];
            // 掉头
            if (row == 0) {
                goesUp = false;
            }
            if (row == numRows - 1) {
                goesUp = true;
            }
            // 跑
            row = (goesUp) ? row - 1 : row + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(matrix[i], 0, cursors[i]);
        }
        return sb.toString();
    }
}
