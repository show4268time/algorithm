package leetcode.code200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: PhilipFry
 * @create: 2022-05-21 09:43
 * @Description: Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 */
public class Code199RightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int l = q.size();
            int n = 0;
            for (int i = 0; i < l; i++) {
                TreeNode node = q.poll();

                n = node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(n);
        }
        return result;
    }
}
