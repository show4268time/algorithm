package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description:
 * @author: yaoweihao
 * @date: 2019/1/10
 * @time: 14:38
 * @modified by:
 */
public class Coordinatesystem {
    public Integer solution(int cx, int cy) {

        int x = 0;
        int y = 0;
        int startNum = 1;
        int heigh = 1;
        int low = -1;
        int left = 1;
        int right = -1;

        while (cx != x && cy != y) {
            x++;
            startNum++;
            int endx = x;
            int endy = y;
            if (cx == x && cy == y) {
                return startNum;
            }

            while (y > low) {
                y--;
                startNum++;
                if (cx == x && cy == y) {
                    return startNum;
                }
            }

            while (x > left) {
                x--;
                startNum++;
                if (cx == x && cy == y) {
                    return startNum;
                }
            }

            while (y < heigh) {
                y++;
                startNum++;
                if (cx == x && cy == y) {
                    return startNum;
                }
            }

            while (x < right) {
                x++;
                startNum++;
                if (cx == x && cy == y) {
                    return startNum;
                }
            }

            while (y > endy){
                y--;
                if(y != endy){
                    startNum++;
                }
                if (cx == x && cy == y) {
                    return startNum;
                }
            }

             heigh ++;
             low --;
             left ++;
             right --;
        }

        return 0;
    }
}
