package leetcode;

/**
 * @program: algorithm
 * @description: 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: showtime
 * @create: 2019-03-10 15:42
 **/
public class Path_Sum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        int val = root.val;
        return hasPathSum(root, sum, val);
    }

    public boolean hasPathSum(TreeNode root, int sum, int cur) {
        if(root.right == null && root.left == null){
            if(sum == cur) return true;
        }

        boolean isLeft = root.left == null ? false : hasPathSum(root.left, sum, root.left.val + cur);
        boolean isRight = root.right == null ? false : hasPathSum(root.right, sum, root.right.val + cur);
        return isLeft || isRight;
    }
}
