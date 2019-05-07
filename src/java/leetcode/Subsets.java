package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @author: yaoweihao
 * @date: 2018/11/30
 * @time: 10:44
 * @modified by:
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
//        subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        //先把输出的东西摆上去。
        List<List<Integer>> result = new ArrayList<>();
        //排除corner case，就是返回一空的。
        if(nums == null || nums.length == 0) return result;
        //这个就是用来搜集每个子集的。
        List<Integer> list = new ArrayList<>();
        dfs(result, list, 0, nums);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> list, int start, int[] nums){
        //先把当前的子集加上，这里添加的语法我命名为『照相法』
        result.add(new ArrayList<>(list));
        //注意这里要从start位置开始循环，否则就是stackoverflow
        for(int i = start; i < nums.length; i++){
            //添加start位置的数字
            list.add(nums[i]);
            //开始递归，比如把1加上去之后，就稳住1，找后面比如2.
            dfs(result, list, i+1, nums);
            //backtrack，就是把之前加上的去掉，相当于往回走，比如之前加到1，2，3
            //就把3去掉，然后再找。
            list.remove(list.size()-1);
        }
    }
}
