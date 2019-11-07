package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *  1.节点的左子树只包含小于当前节点的数。
 *  2.节点的右子树只包含大于当前节点的数。
 *  3.所有左子树和右子树自身必须也是二叉搜索树。
 * @author: yaoweihao
 * @date: 2019/2/18
 * @time: 15:08
 * @modified by:
 */
public class Validate_Binary_Search_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;
        long pre = Long.MIN_VALUE;
        while (temp != null || !stack.isEmpty()){
            while (temp!= null){
                stack.offerFirst(temp);
                temp = temp.left;
            }
            temp = stack.pollFirst();
            if(temp.val <= pre) return false;
            pre = temp.val;
            temp = temp.right;
        }
        return true;
    }
}
