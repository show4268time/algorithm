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

    Map<Long, Long> map = new HashMap<>();
    Long res = 0l;
    long t = 0;

    public int pathSum(TreeNode root, int targetSum) {
        t = (long) targetSum;
        map.put(0l, 1l);
        dfs(root, 0l);
        return res.intValue();
    }

    void dfs(TreeNode node, long cur) {
        if (node == null) return;
        cur = cur + (long) node.val;
        res += map.getOrDefault(cur - t, 0l);
        map.put(cur, map.getOrDefault(cur, 0l) + 1l);
        dfs(node.left, cur);
        dfs(node.right, cur);
        map.put(cur, map.getOrDefault(cur, 0l) - 1l);
    }
}
