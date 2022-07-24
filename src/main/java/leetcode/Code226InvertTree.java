package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-13 23:04
 * @Description: Given the root of a binary tree, invert the tree, and return its root.
 */
public class Code226InvertTree {
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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode l = root.left;

        root.left = root.right;
        root.right = l;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

}
