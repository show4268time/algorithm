package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-19 22:47
 * @Description: Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class Code103ZigzagLevelOrder {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> firstList = new LinkedList<>();
        LinkedList<TreeNode> secondList = new LinkedList<>();
        firstList.addFirst(root);

        while (firstList.size() > 0 || secondList.size() > 0) {
            if (firstList.size() > 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = firstList.size(); i > 0; i--) {
                    TreeNode node = firstList.poll();
                    list.add(node.val);
                    if (node.left != null) secondList.addFirst(node.left);
                    if (node.right != null) secondList.addFirst(node.right);
                }
                result.add(list);
            }

            if (secondList.size() > 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = secondList.size(); i > 0; i--) {
                    TreeNode node = secondList.poll();
                    list.add(node.val);
                    if (node.right != null) firstList.addFirst(node.right);

                    if (node.left != null) firstList.addFirst(node.left);
                }
                result.add(list);
            }
        }
        return result;
    }
}
