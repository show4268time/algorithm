package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 16:22
 * @Description: A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class Code124MaxPathSum {

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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = Math.max(0, dfs(node.left));
        int r = Math.max(0, dfs(node.right));
        int v = node.val;
        res = Math.max(res, v + l + r);

        return v + Math.max(l, r);
    }
}
