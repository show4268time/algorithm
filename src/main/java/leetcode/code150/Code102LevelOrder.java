package leetcode.code150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: PhilipFry
 * @create: 2022-05-19 09:55
 * @Description: Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class Code102LevelOrder {

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

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        levelOrder(list);

        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return result;
        q.offer(root);
        while (q.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }

    private void levelOrder(List<TreeNode> list) {
        if (list.size() == 0) return;

        List<Integer> levelList = new ArrayList<>();
        List<TreeNode> backList = new ArrayList<>();
        for (TreeNode treeNode : list) {
            levelList.add(treeNode.val);
            if (treeNode.left != null) {
                backList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                backList.add(treeNode.right);
            }
        }
        result.add(levelList);
        levelOrder(backList);
    }

}
