package WeeklyContest.BiweeklyContest79;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-29 08:17
 * @Description: You are given an integer n denoting the number of cities in a country.
 * The cities are numbered from 0 to n - 1.
 * You are also given a 2D integer array roads where roads[i] = [ai, bi]
 * denotes that there exists a bidirectional road connecting cities ai and bi.
 * You need to assign each city with an integer value from 1 to n, where each value can only be used once.
 * The importance of a road is then defined as the sum of the values of the two cities it connects.
 * Return the maximum total importance of all roads possible after assigning the values optimally.
 */
public class Contest2285MaximumImportance {
    public long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        for (int road[] : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long ans = 0, x = 1;
        for (long i : degree) ans += i * (x++);
        return ans;
    }
}
