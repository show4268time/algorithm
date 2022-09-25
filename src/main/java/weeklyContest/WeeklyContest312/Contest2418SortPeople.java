package weeklyContest.WeeklyContest312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-09-25 15:14
 * @Description: You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 * <p>
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * <p>
 * Return names sorted in descending order by the people's heights.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.
 * Example 2:
 * <p>
 * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * Output: ["Bob","Alice","Bob"]
 * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 */
public class Contest2418SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(heights[n - i - 1]);
        }
        return res;
    }
}
