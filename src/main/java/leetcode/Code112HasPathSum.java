package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 09:24
 * @Description: Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 */
public class Code112HasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        int target = sum - root.val;

        return hasPathSum(root.left, target) || hasPathSum(root.right, target);

    }
}
