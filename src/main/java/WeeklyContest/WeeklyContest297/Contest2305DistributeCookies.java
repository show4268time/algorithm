package WeeklyContest.WeeklyContest297;

/**
 * @author: PhilipFry
 * @create: 2022-06-12 13:23
 * @Description: You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag.
 * You are also given an integer k that denotes the number of children to distribute all the bags of cookies to.
 * All the cookies in the same bag must go to the same child and cannot be split up.
 * <p>
 * The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
 * <p>
 * Return the minimum unfairness  of all distributions.
 */
public class Contest2305DistributeCookies {
    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] q = new int[k];
        dfs(cookies, q, 0);
        return res;
    }

    private void dfs(int[] cookies, int[] q, int index) {
        if (index == cookies.length) {
            int sum = 0;
            for (int i = 0; i < q.length; i++) {
                sum = Math.max(sum, q[i]);
            }
            res = Math.min(res, sum);

            return;
        }

        for (int i = 0; i < q.length; i++) {
            q[i] += cookies[index];
            if (q[i] < res) {
                dfs(cookies, q, index + 1);
            }
            q[i] -= cookies[index];
        }
    }
}
