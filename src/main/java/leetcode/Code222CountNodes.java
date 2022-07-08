package leetcode;

import java.util.LinkedList;

/**
 * @author: PhilipFry
 * @create: 2022-05-21 11:48
 * @Description: Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia,
 * every level, except possibly the last,
 * is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 */
public class Code222CountNodes {
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

    private int sum = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        countNodes(list, 0);

        return sum;
    }

    public void countNodes(LinkedList<TreeNode> backtrack, int heigh) {
        if (backtrack.isEmpty()) {
            return;
        }
        sum = sum + (int) Math.pow(2, heigh);
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        TreeNode curRight = backtrack.peek();
        while (!backtrack.isEmpty()) {
            TreeNode node = backtrack.poll();
            if (node.right != null) nextLevel.offer(node.right);
            if (node.left != null) nextLevel.offer(node.left);
        }

        if (curRight.right == null) {
            sum = sum + nextLevel.size();
            return;
        }

        heigh++;
        countNodes(nextLevel, heigh);
    }
}
