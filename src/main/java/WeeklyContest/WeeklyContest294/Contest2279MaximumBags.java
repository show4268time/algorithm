package WeeklyContest.WeeklyContest294;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-05-22 14:38
 * @Description: You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks.
 * The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks.
 * You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.
 * Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.
 */
public class Contest2279MaximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        //背包装满还需要多少石头
        int[] nums = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            nums[i] = capacity[i] - rocks[i];
        }
        int ans = 0;
        //题目中要获得最大背包装满数，那应该先将缺石头的比较少的背包先装满，此时获得的是最大背包装满数，应该将nums数组先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && additionalRocks > 0; i++) {
            //nums[i] == 0 表示背包已经装满
            if (nums[i] == 0) {
                ans++;
                continue;
            }
            if (nums[i] <= additionalRocks) {
                ans++;
                additionalRocks -= nums[i];
            }
        }
        return ans;
    }
}
