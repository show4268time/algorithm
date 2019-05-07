package leetcode;


/**
 * @program: algorithm
 * @description: 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 * @author: showtime
 * @create: 2019-03-10 20:38
 **/
public class Flatten_Binary_Tree_to_Linked_List {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {

        if(root == null) return;
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;

     }
}
