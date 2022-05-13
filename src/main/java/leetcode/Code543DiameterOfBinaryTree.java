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

    private Integer maxDiameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDe(root);

        return maxDiameter;
    }

    private int maxDe(TreeNode root) {
        if (root == null) return 0;
        int left = maxDe(root.left);
        int right = maxDe(root.right);
        int myDiameter = left + right;
        maxDiameter = Math.max(myDiameter, maxDiameter);
        return Math.max(left, right) + 1;
    }
}
