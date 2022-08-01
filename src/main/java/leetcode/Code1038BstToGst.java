package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-31 23:08
 * @Description:
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that
 * <p>
 * every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Code1038BstToGst {
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

    int t = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.right);
        t += node.val;
        node.val = t;
        dfs(node.left);
    }
}
