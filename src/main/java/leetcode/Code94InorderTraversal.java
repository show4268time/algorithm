package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-17 19:56
 * @Description: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class Code94InorderTraversal {
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

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;
        if (root.left != null) inorderTraversal(root.left);

        result.add(root.val);

        if (root.right != null) inorderTraversal(root.right);
        return result;
    }
}
