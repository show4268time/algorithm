package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * @author: showtime
 * @create: 2019-03-09 20:13
 **/
public class Binary_Tree_Level_Order_Traversal_II {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        if(root != null){
            nodes.add(root);
            while (nodes.size() > 0){
                List<Integer> list = new ArrayList<>();
                for(int i = nodes.size(); i > 0; i --){
                    TreeNode treeNode = nodes.poll();
                    list.add(treeNode.val);
                    if(treeNode.left != null) nodes.add(treeNode.left);
                    if(treeNode.right != null)nodes.add(treeNode.right);
                }
                queue.add(list);
            }
            while (queue.size() > 0){
                result.add(((LinkedList<List<Integer>>) queue).removeLast());
            }
        }

        return result;
    }
}
