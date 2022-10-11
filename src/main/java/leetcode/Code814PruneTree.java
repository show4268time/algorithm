package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-24 23:22
 * @Description: Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * A subtree of a node node is node plus every node that is a descendant of node.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 */
public class Code814PruneTree {
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

    public TreeNode pruneTree(TreeNode root) {
        boolean t = dfs(root);
        if (t) return null;
        return root;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) return true;

        boolean l = dfs(node.left);
        if (l) node.left = null;
        boolean r = dfs(node.right);
        if (r) node.right = null;

        return l && r && node.val == 0;

    }
}
