package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-08-07 17:55
 * @Description:
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
