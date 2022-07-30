package leetcode.code200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-12 15:59
 * @Description: Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class Code144PreorderTraversal {
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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return result;
    }
}
