package leetcode;

/**
 * @program: algorithm
 * @description: 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @author: showtime
 * @create: 2019-03-10 11:20
 **/
public class Balanced_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {

        if(checkDepth(root) == -1) return false;

        return true;
    }


    public int checkDepth(TreeNode root) {

        if(root == null) return 0;
        int left = checkDepth(root.left);
        if(left == -1) return -1;

        int right = checkDepth(root.right);
        if(right == -1) return -1;

        int abs = Math.abs(left - right);
        if(abs > 1) return -1;

        return 1 + Math.max(left , right);
    }
}
