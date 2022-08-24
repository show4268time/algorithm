package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: PhilipFry
 * @create: 2022-08-24 22:58
 * @Description: Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Example 1:   Input: root = [2,1,3] Output: 1
 * <p>
 * Example 2:   Input: root = [1,2,3,4,null,5,6,null,null,7] Output: 7
 */
public class Code513FindBottomLeftValue {
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

    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = q.poll();

                if (i == 0) res = node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
