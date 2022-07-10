package weeklyContest.WeeklyContest301;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-07-10 12:32
 * @Description: You have a water dispenser that can dispense cold, warm, and hot water.
 * <p>
 * Every second, you can either fill up 2 cups with different types of water, or 1 cup of any type of water.
 * <p>
 * You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1], and amount[2] denote the number of cold,
 * <p>
 * warm, and hot water cups you need to fill respectively. Return the minimum number of seconds needed to fill up all the cups.
 */
public class Contest2335FillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);

        int res = 0;
        while (amount[2] > 0) {
            amount[2]--;
            if (amount[1] > 0) {
                amount[1]--;
            }
            res++;
            Arrays.sort(amount);
        }
        return res;
    }
}
