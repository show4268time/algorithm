package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-07-31 00:01
 * @Description: 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class Code437PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;
    Map<Long, Integer> map = new HashMap<>();
    int t = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0l, 1);
        t = targetSum;
        dfs(root, 0l);
        return res;
    }

    private void dfs(TreeNode node, long sum) {
        if (node == null) return;

        sum += node.val;
        long d = sum - t;
        res += map.getOrDefault(d, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(node.left, sum);
        dfs(node.right, sum);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
