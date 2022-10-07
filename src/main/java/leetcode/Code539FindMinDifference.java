package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-10-07 23:16
 * @Description: Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 * <p>
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 */
public class Code539FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            String[] strs = s.split(":");
            time[i] = Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
        }

        Arrays.sort(time);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < time.length; i++) {
            if (time[i - 1] == time[i]) return 0;
            res = Math.min(res, time[i] - time[i - 1]);
        }

        res = Math.min(res, time[0] + 24 * 60 - time[time.length - 1]);
        return res;
    }
}
