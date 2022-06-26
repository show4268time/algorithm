package weeklyContest.WeeklyContest296;

/**
 * @author: PhilipFry
 * @create: 2022-06-05 13:07
 * @Description: You are given a 0- indexed (指数) integer array (阵列) nums whose length is a power of 2.
 * Apply the following algorithm (算法) on nums:  Let n be the length of nums. If n == 1, end the process.
 * Otherwise, create a new 0- indexed (指数) integer array (阵列) newNums of length n / 2.
 * For every even index (指数) i where 0 <= i < n / 2, assign (分配) the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
 * For every odd (奇怪) index (指数) i where 0 <= i < n / 2, assign (分配) the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
 * Replace the array (阵列) nums with newNums. Repeat the entire process starting from step 1.
 */
public class Contest2293MinMaxGame {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] num = new int[nums.length / 2];
        if (num.length == 1) {
            return Math.min(nums[0], nums[1]);
        }

        int left = 0, right = 1, med = 0;
        while (right < nums.length) {
            if (med % 2 == 0) {
                num[med] = Math.min(nums[left], nums[right]);
            } else {
                num[med] = Math.max(nums[left], nums[right]);
            }
            left += 2;
            right += 2;
            med++;
        }
        return minMaxGame(num);
    }
}
