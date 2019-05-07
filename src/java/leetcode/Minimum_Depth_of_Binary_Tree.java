package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: showtime
 * @create: 2019-03-10 13:17
 **/
public class Minimum_Depth_of_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        int cunt = 0;
        if(root != null){
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            cunt++;
            while (nodes.size() > 0){
                boolean isMin = false;
                for(int i = nodes.size(); i > 0; i--){
                    TreeNode treeNode = nodes.poll();
                    if(treeNode.left == null && treeNode.right == null){
                        isMin = false;
                        break;
                    }else {
                        isMin = true;
                        if(treeNode.left != null) nodes.add(treeNode.left);
                        if(treeNode.right != null) nodes.add(treeNode.right);
                    }
                }
                if(!isMin){
                    break;
                }
                cunt++;
            }
        }

        return cunt;
    }
}
