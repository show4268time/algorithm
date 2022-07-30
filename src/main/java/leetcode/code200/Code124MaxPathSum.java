package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 16:22
 * @Description: A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class Code124MaxPathSum {

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

    public static void main(String[] args) {
        String s = "1";
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // base case
        if (root == null) return 0;

        max(root);

        return maxSum;
    }

    public int max(TreeNode root) {
        // base case
        if (root == null) return 0;
        String s;

        // recursing through left and right subtree
        int leftMax = max(root.left);
        int rightMax = max(root.right);

        // finding all the four paths and the maximum between all of them
        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);

        // Storing the result in the maxSum holder
        maxSum = Math.max(maxSum, maxAll);

        // returning the value if root was part of the answer
        return maxOneNodeRoot;
    }
}
