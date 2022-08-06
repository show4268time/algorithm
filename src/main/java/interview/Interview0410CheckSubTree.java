package interview;

/**
 * @author: PhilipFry
 * @create: 2022-08-06 13:59
 * @Description: 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 */
public class Interview0410CheckSubTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        if (check(t1, t2)) return true;

        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }


    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;

        if (t1 != null && t2 != null) {
            if (t1.val != t2.val) return false;
            return check(t1.left, t2.left) && check(t1.right, t2.right);
        }

        if (t1 != null && t2 == null) return true;

        return false;
    }
}
