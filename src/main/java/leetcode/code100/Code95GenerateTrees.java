package leetcode.code100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-18 09:48
 * @Description: Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
public class Code95GenerateTrees {
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new LinkedList<>();

        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftNodes = generateTrees(left, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);

                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);

                }
            }
        }
        return res;
    }
}
