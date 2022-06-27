package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-06-26 21:09
 * @Description: There are several cards arranged in a row, and each card has an associated number of points.
 * <p>
 * The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class Code1423MaxScore {

    int res = 0;

    /**
     * 滑动窗口
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore1(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int min = Integer.MAX_VALUE;
        int now = 0;
        int res = len - k;
        int total = 0;
        for(int i = 0; i< res; i++){
            now += cardPoints[i];
            total = now;
        }

        min = now;
        for(int i = res ; i< len; i++){
            now = now - cardPoints[i -res] + cardPoints[i];
            min = Math.min(min, now);
            total += cardPoints[i];
        }
        return total - min;
    }

    /**
     * dfs 会超时
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(n == k){
            for(int i = 0; i< n; i++){
                res += cardPoints[i];
            }
            return res;
        }
        dfs(cardPoints, k, 0, n-1, 0);
        return res;
    }

    private void dfs(int[] cardPoints, int k, int start, int end, int count){
        if(k == 0 || start > end){
            res = Math.max(count, res);
            return;
        }

        dfs( cardPoints, k -1, start +1, end, count + cardPoints[start]);
        dfs( cardPoints, k -1, start , end  - 1, count + cardPoints[end]);

    }
}
