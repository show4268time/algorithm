package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-08-06 14:27
 * @Description: 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 */
public class Interview0412PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    int s = 0;

    public int pathSum(TreeNode root, int sum) {
        s = sum;
        map.put(0, 1);
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int cur) {
        if (node == null) return;

        cur += node.val;
        res += map.getOrDefault(cur - s, 0);
        if (map.get(cur) == null) map.put(cur, 0);
        map.put(cur, map.get(cur) + 1);
        dfs(node.left, cur);
        dfs(node.right, cur);
        map.put(cur, map.get(cur) - 1);
    }
}
