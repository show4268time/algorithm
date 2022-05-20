package main.java.leetcode;

import java.util.LinkedList;

/**
 * @author: PhilipFry
 * @create: 2022-05-16 09:42
 * @Description: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class Code111MinDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(20);
        node1.left =  new TreeNode(15);
        node1.right =  new TreeNode(17);

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(9);
        root.right = node1;

        BFS(root);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);

        return Math.min(left, right) + 1;
    }

    public static int BFS(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> levelList = new LinkedList<>();
        levelList.offer(root);
        int level = 1;

        while (!levelList.isEmpty()) {
            for (int i = levelList.size(); i > 0; i--) {
                TreeNode node = levelList.removeFirst();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) levelList.offer(node.left);
                if (node.right != null) levelList.offer(node.right);
            }
            level++;
        }
        return level;
    }
}
