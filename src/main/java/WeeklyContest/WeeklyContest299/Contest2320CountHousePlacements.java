package WeeklyContest.WeeklyContest299;

/**
 * @author: PhilipFry
 * @create: 2022-06-26 13:24
 * @Description: There is a street with n * 2 plots, where there are n plots on each side of the street. The plots on each side are numbered from 1 to n.
 * <p>
 * On each plot, a house can be placed.
 * <p>
 * Return the number of ways houses can be placed such that no two houses are adjacent to each other on the same side of the street.
 * <p>
 * Since the answer may be very large, return it modulo 109 + 7.
 * <p>
 * Note that if a house is placed on the ith plot on one side of the street, a house can also be placed on the ith plot on the other side of the street.
 */
public class Contest2320CountHousePlacements {
    public int countHousePlacements(int n) {
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        int MOD = 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 + 7;
        f[1] = g[1] = 1l;
        for (int i = 2; i <= n; i++) {
            g[i] = (f[i - 1] + g[i - 1]) % MOD;
            f[i] = g[i - 1];
        }
        long res = (f[n] + g[n]) * (f[n] + g[n]);
        return (int) (res % MOD);
    }
}
