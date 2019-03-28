package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: yaoweihao
 * @date: 2019/3/26
 * @time: 10:04
 * @modified by:
 */
public class Sum_Root_to_Leaf_Numbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, root.val);
    }

    public int sumNumbers(TreeNode treeNode, int sum){
        if(treeNode.right == null && treeNode.left == null) return sum;

        int left  =  treeNode.left == null ? 0 : sumNumbers(treeNode.left, sum * 10 + treeNode.left.val);
        int right =  treeNode.right == null ? 0 : sumNumbers(treeNode.right, sum * 10 + treeNode.right.val);
        return right + left;
    }
}
