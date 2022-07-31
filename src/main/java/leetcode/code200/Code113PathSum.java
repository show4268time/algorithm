package leetcode.code200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 09:46
 * @Description: Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * <p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * A leaf is a node with no children.
 */
public class Code113PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path);
        return res;

    }

    private void dfs(TreeNode node, int t, LinkedList<Integer> path) {
        if (node == null) return;

        t -= node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (t == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(node.left, t, path);
        dfs(node.right, t, path);
        path.removeLast();
    }
}
