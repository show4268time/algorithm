package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author: yaoweihao
 * @date: 2019/3/7
 * @time: 9:57
 * @modified by:
 */
public class Same_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else if(p == null && q == null){
            return true;
        }

        return false;
    }
}
