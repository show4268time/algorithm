package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @author: yaoweihao
 * @date: 2019/3/7
 * @time: 15:50
 * @modified by:
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        root.left = treeNode2;
        root.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        zigzagLevelOrder(root);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<TreeNode> nextNodes = new LinkedList<>();
        nodes.addFirst(root);

        while (nodes.size() > 0 || nextNodes.size() > 0) {
            List<Integer> list = new ArrayList<>();
            if(nodes.size() > 0){
                for(int i = nodes.size(); i > 0; i--){
                    TreeNode treeNode = nodes.removeFirst();
                    if(treeNode != null){
                        list.add(treeNode.val);
                        if(treeNode.left != null) nextNodes.addFirst(treeNode.left);
                        if(treeNode.right != null) nextNodes.addFirst(treeNode.right);
                    }
                }
            }else if(nextNodes.size() > 0){
                for(int i = nextNodes.size(); i > 0; i--){
                    TreeNode treeNode = nextNodes.removeFirst();
                    if(treeNode != null){
                        list.add(treeNode.val);
                        if(treeNode.right != null) nodes.addFirst(treeNode.right);
                        if(treeNode.left != null) nodes.addFirst(treeNode.left);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
