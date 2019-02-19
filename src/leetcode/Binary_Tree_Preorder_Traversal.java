package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个二叉树，原地将它展开为链表
 * @author: yaoweihao
 * @date: 2019/2/18
 * @time: 17:36
 * @modified by:
 */
public class Binary_Tree_Preorder_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    /**
     * 迭代版
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pollFirst();
            if(treeNode != null){
                result.add(treeNode.val);
                stack.offerFirst(treeNode.right);
                stack.offerFirst(treeNode.left);
            }
        }
        return result;
    }
}
