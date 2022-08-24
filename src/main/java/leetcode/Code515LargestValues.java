package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: PhilipFry
 * @create: 2022-08-24 22:49
 * @Description: Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * <p>
 * Example 1:   Input: root = [1,3,2,5,3,null,9] Output: [1,3,9]
 * <p>
 * Example 2:  Input: root = [1,2,3] Output: [1,3]
 */
public class Code515LargestValues {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int l = q.size();
            int s = Integer.MIN_VALUE;
            for (int i = 0; i < l; i++) {
                TreeNode node = q.poll();
                s = Math.max(s, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(s);
        }
        return result;
    }
}
