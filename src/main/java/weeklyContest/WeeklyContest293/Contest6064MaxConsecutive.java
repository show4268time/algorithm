package weeklyContest.WeeklyContest293;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-15 11:27
 * @Description: Alice manages a company and has rented some floors of a building as office space.
 * Alice has decided some of these floors should be special floors, used for relaxation only.
 * You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive).
 * You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.
 * Return the maximum number of consecutive floors without a special floor.
 */
public class Contest6064MaxConsecutive {
    public static void main(String[] args) {
        int[] special = new int[]{39, 46, 2, 14, 13, 42};
        maxConsecutive(2, 49, special);
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int length = special.length;

        int max = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }

        return max;
    }
}
