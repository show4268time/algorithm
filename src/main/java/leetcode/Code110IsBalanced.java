package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-19 20:35
 * @Description: Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class Code110IsBalanced {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {

        if (getAbs(root) == -1) return false;

        return true;
    }

    private int getAbs(TreeNode root) {
        if (root == null) return 0;

        int left = getAbs(root.left);
        if (left == -1) return -1;

        int right = getAbs(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
