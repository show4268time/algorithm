package weeklyContest.WeeklyContest300;

/**
 * @author: PhilipFry
 * @create: 2022-07-03 23:10
 * @Description: On day 1, one person discovers a secret.
 * <p>
 * You are given an integer delay, which means that each person will share the secret with a new person every day,
 * <p>
 * starting from delay days after discovering the secret. You are also given an integer forget,
 * <p>
 * which means that each person will forget the secret forget days after discovering it.
 * <p>
 * A person cannot share the secret on the same day they forgot it, or on any day afterwards.
 * <p>
 * Given an integer n, return the number of people who know the secret at the end of day n.
 * <p>
 * Since the answer may be very large, return it modulo 109 + 7.
 */
public class Contest2327PeopleAwareOfSecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000000 + 7;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + delay; j < Math.min(i + forget, n); j++) {
                dp[j] = (dp[j] + dp[i]) % mod;
            }
        }

        int sum = 0;
        for (int i = n - forget; i < n; i++) {
            sum = (sum + dp[i]) % mod;
        }
        return sum;
    }
}
