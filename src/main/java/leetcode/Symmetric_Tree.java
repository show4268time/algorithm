package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @author: yaoweihao
 * @date: 2019/3/7
 * @time: 10:16
 * @modified by:
 */
public class Symmetric_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        if( root.left == null && root.right == null){
            return true;
        }

        return isSameTree(root.left, root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }else {
                return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
            }
        }else if(p == null && q == null){
            return true;
        }

        return false;
    }
}
