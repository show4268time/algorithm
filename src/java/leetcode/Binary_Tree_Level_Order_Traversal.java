package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @author: yaoweihao
 * @date: 2019/3/7
 * @time: 11:18
 * @modified by:
 */
public class Binary_Tree_Level_Order_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes.size() > 0) {
            List<Integer> list = new ArrayList<>();
            for(int i = nodes.size(); i > 0; i--){
                TreeNode treeNode = nodes.poll();
                if (treeNode != null) {
                    list.add(treeNode.val);
                    if(treeNode.left != null) nodes.add(treeNode.left);
                    if(treeNode.right != null) nodes.add(treeNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
