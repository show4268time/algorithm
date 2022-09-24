package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-08-12 21:18
 * @Description: 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Offer03FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]]) return nums[i];
            int temp = nums[i];
            nums[i] =  nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){
                int temp = nums[nums[i]];
                if(temp == nums[i]) return nums[i];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }
}
