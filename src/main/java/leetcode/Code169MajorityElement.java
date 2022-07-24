package leetcode;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-07-24 14:59
 * @Description: 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Code169MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int count = 1;
        int l = 0, r = 1;
        while (r < nums.length) {

            if (nums[l] == nums[r]) {
                count++;
            } else {
                count = 1;
            }

            if (count > n) return nums[l];

            l++;
            r++;
        }
        return nums[0];
    }

    public int majorityElement1(int[] nums) {
        int r = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(r == nums[i]){
                count++;
            }else{
                if(count > 0){
                    count--;
                }else{
                    r = nums[i];
                    count =1;
                }
            }
        }
        return r;
    }
}
