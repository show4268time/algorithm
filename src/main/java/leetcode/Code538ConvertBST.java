package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-10-14 22:59
 * @Description: Given the root of a Binary Search Tree (BST),
 * <p>
 * convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * <p>
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * <p>
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * <p>
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * Example 2:  I
 * <p>
 * nput: root = [0,null,1]
 * <p>
 * Output: [1,null,1]
 */
public class Code538ConvertBST {

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

    int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
        return root;
    }
}
