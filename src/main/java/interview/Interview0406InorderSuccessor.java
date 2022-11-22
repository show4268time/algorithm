package interview;

/**
 * @author: PhilipFry
 * @create: 2022-11-22 23:38
 * @Description: 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 */
public class Interview0406InorderSuccessor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode result = null;
    boolean pre;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        dfs(root, p);
        return result;
    }

    private void dfs(TreeNode node, TreeNode p) {
        if (pre && result != null) return;

        if (node.left != null) dfs(node.left, p);
        if (pre) {
            if (result == null) {
                result = node;
            }
            return;
        } else {
            if (node == p) {
                pre = true;
            }
            if (node.right != null) dfs(node.right, p);
        }
    }
}
