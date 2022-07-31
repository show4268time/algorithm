package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-07-31 16:37
 * @Description: 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果
 */
public class Code448FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] c = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            c[nums[i]]++;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (c[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
