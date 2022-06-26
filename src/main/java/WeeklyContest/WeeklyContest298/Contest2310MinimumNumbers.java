package WeeklyContest.WeeklyContest298;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-06-19 23:06
 * @Description: 给你两个整数 num 和 k ，考虑具有以下属性的正整数多重集：
 * <p>
 * 每个整数个位数字都是 k 。
 * 所有整数之和是 num 。
 * 返回该多重集的最小大小，如果不存在这样的多重集，返回 -1 。
 * <p>
 * 注意：
 * <p>
 * 多重集与集合类似，但多重集可以包含多个同一整数，空多重集的和为 0 。
 * 个位数字 是数字最右边的数位。
 */
public class Contest2310MinimumNumbers {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;

        int[] dp = new int[num + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (i % 10 == k) {
                list.add(i);
            }
        }
        int m = list.size();
        for (int i = 0; i < m; i++) {
            int x = list.get(i);
            for (int j = x; j <= num; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[num] == 0x3f3f3f3f ? -1 : dp[num];
    }
}
