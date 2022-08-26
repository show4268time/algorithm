package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-26 23:39
 * @Description: Given the root of a Binary Search Tree and a target number k,
 * <p>
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 */
public class Code653FindTarget {
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

    TreeNode first = null;
    TreeNode target = null;

    public boolean findTarget(TreeNode root, int k) {
        if (first == null) first = root;
        if (root == null) return false;
        int t = k - root.val;
        target = root;
        if (find(first, t)) return true;
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    private boolean find(TreeNode node, int k) {
        if (node == null) return false;
        if (node.val == k && node != target) return true;
        else if (node.val > k) return find(node.left, k);
        else return find(node.right, k);
    }
}
