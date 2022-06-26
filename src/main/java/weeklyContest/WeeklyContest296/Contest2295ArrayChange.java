package weeklyContest.WeeklyContest296;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-06-05 13:11
 * @Description: You are given a 0- indexed (指数) array (阵列) nums that consists of n distinct (鲜明) positive integers.
 * Apply m operations to this array (阵列) , where in the ith operation you replace the number operations[i][0] with operations[i][1].
 * It is guaranteed (保证) that in the ith operation:  operations[i][0] exists in nums. operations[i][1] does not exist in nums.
 * Return the array (阵列) obtained after applying all the operations.
 */
public class Contest2295ArrayChange {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < operations.length; i++) {
            int org = operations[i][0];
            int pre = operations[i][1];
            if(map.get(org) != null){
                nums[map.get(org)] = pre;
                map.put(pre, map.get(org));
            }
        }

        return nums;
    }
}
