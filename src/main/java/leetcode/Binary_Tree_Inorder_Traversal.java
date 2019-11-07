package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个二叉树，返回它的中序 遍历。
 * @author: yaoweihao
 * @date: 2019/2/18
 * @time: 14:13
 * @modified by:
 */
public class Binary_Tree_Inorder_Traversal {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()){
            while (temp != null){
                stack.offerFirst(temp);
                temp = temp.left;
            }
            temp = stack.pollFirst();
            result.add(temp.val);
            temp = temp.right;
        }
        return result;
    }
}
