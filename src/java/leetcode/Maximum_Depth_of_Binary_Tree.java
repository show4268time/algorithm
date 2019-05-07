package leetcode;

/**
 * @program: algorithm
 * @description: 给定一个二叉树，找出其最大深度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: showtime
 * @create: 2019-03-08 18:25
 **/
public class Maximum_Depth_of_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        int num = 0;
        if(root != null){
            if(root.left == null && root.right == null){
                return 1;
            }else {
                return Math.max(maxDepth(root.left) + 1 , maxDepth(root.right) + 1);
            }

        }
        return num;
    }
}
