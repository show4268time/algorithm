package weeklyContest.WeeklyContest294;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-05-22 14:40
 * @Description: You are given a 2D integer array stockPrices where
 * stockPrices[i] = [dayi, pricei] indicates the price of the stock on day dayi is pricei.
 * A line chart is created from the array by plotting the points on an XY plane with the X-axis representing the day and
 * the Y-axis representing the price and connecting adjacent points. One such example is shown below:
 */
public class Contest2280MinimumLines {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) return 0;

        Map<Long, Long> map = new HashMap<>();

        if (stockPrices.length == 1) return 0;
        int count = 1;
        Long[] memo = new Long[stockPrices.length];
        for (int i = 0; i < stockPrices.length; i++) {
            map.put(new Long(stockPrices[i][0]), new Long(stockPrices[i][1]));
            memo[i] = new Long(stockPrices[i][0]);
        }
        Arrays.sort(memo);
        if (stockPrices.length > 1) {
            int first = 0;
            int sec = 1;
            Long preWDiff = null;
            Long preHDiff = null;

            while (sec < stockPrices.length) {
                Long Wdiff = memo[sec] - memo[first];
                Long Hdiff = map.get(memo[sec]) - map.get(memo[first]);

                if (preWDiff != null) {

                    if (Wdiff * preHDiff == preWDiff * Hdiff) {

                    } else {
                        count++;
                    }
                }
                preWDiff = Wdiff;
                preHDiff = Hdiff;
                sec++;
                first++;
            }
        }
        return count;
    }
}
