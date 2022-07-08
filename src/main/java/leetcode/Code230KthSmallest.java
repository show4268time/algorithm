package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-21 13:58
 * @Description: Given the root of a binary search tree,
 * and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class Code230KthSmallest {

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

    private int rank = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        travse(root, k);
        return res;
    }

    private void travse(TreeNode node, int k) {
        if (node == null) return;
        travse(node.left, k);
        rank++;

        if (rank == k) {
            res = node.val;
            return;
        }
        travse(node.right, k);

    }
}
