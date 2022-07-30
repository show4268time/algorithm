package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-05-12 15:47
 * @Description: Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Code104MaxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        return Math.max(rightCount, leftCount) + 1;
    }
}
