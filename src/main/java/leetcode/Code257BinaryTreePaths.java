package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-21 22:42
 * @Description: Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 */
public class Code257BinaryTreePaths {

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

    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        travse(root, "");
        return result;
    }

    private void travse(TreeNode node, String pre) {
        if (node == null) {
            result.add(pre);
        }
        String str = "";
        if (pre.length() == 0) {
            str = String.valueOf(node.val);
        } else {
            str = pre + "->" + node.val;

        }
        if (node.left != null) {
            travse(node.left, str);
        }
        if (node.right != null) {
            travse(node.right, str);
        }
        if (node.left == null && node.right == null) {
            result.add(str);
            return;

        }
    }
}
