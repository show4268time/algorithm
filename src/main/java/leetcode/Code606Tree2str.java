package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-09-09 00:05
 * @Description: Given the root of a binary tree,
 * construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way,
 * and return it.
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 */
public class Code606Tree2str {
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

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        String res = "" + root.val;
        String l = tree2str(root.left);
        String r = tree2str(root.right);
        if (l == "" && r == "") return res;
        if (r == "") return res + "(" + l + ")";
        return res + "(" + l + ")" + "(" + r + ")";
    }
}
