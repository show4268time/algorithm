package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-21 15:16
 * @Description: Given a binary search tree (BST),
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class Code235LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }

        if (p.val > root.val) {
            return lowestCommonAncestor(root.right, q, p);
        }

        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, q, p);
        }

        return null;
    }
}
