package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-08-07 17:55
 * @Description: 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Interview0804Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new LinkedList<>());
        return res;
    }


    private void dfs(int[] nums, int index, LinkedList<Integer> path) {
        if (nums.length == index) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, index + 1, path);

        path.add(nums[index]);

        dfs(nums, index + 1, path);

        path.removeLast();
    }
}
