package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-12 17:58
 * @Description: Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class Code543DiameterOfBinaryTree {
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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        int left = node.left == null ? 0 : dfs(node.left) + 1;
        int right = node.right == null ? 0 : dfs(node.right) + 1;
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
