package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: PhilipFry
 * @create: 2022-05-19 11:29
 * @Description: Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 */
public class Code107LevelOrderBottom {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> levelList = new LinkedList<>();
        levelList.offer(root);

        while (!levelList.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            for (int i = levelList.size(); i > 0; i--) {
                TreeNode node = levelList.poll();
                list.add(node.val);
                if (node.left != null) levelList.offer(node.left);
                if (node.right != null) levelList.offer(node.right);

            }
            result.addFirst(list);
        }

        return result;
    }
}
