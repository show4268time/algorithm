package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 18:07
 * @Description: You are given the root of a binary tree containing digits from 0 to 9 only.
 * <p>
 * Each root-to-leaf path in the tree represents a number.
 * <p>
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * A leaf node is a node with no children.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Code129SumNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int pre) {
        if (node == null) return 0;

        pre = pre * 10 + node.val;

        if (node.left == null && node.right == null) return pre;

        return dfs(node.left, pre) + dfs(node.right, pre);
    }

    int res = 0;

    public int sumNumbers1(TreeNode root) {
        if (root == null) return res;
        dfs1(root, 0);
        return res;
    }

    private void dfs1(TreeNode node, int pre) {

        pre = pre * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += pre;
            return;
        } else {
            if (node.left != null) dfs1(node.left, pre);
            if (node.right != null) dfs1(node.right, pre);
        }
    }
}
