package leetcode.code100;

/**
 * @author: PhilipFry
 * @create: 2022-05-18 23:14
 * @Description: You are given the root of a binary search tree (BST),
 * where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class Code99RecoverTree {
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

    private TreeNode pre, node1, node2;

    /**
     * Here, we leverage the fact that Inorder Traversal of a BST gives a sorted list of elements.
     * If there are exactly 2 swapped nodes, we can check the mistake in the inorder traversal.
     * For eg.,
     * root = [6,2,5,null,null,null,3]
     * Inorder traversal: [2,6,5,3] (Not sorted).
     * <p>
     * First incorrect node/element is 6 because 6 > 5 (first == null && prev > curr) => prev is the first node.
     * Second incorrect node/element is 3, because 5 > 3 (first != null && prev > curr), curr is the second node.
     * To cover the edge-case of 2 consecutive elements to be swapped, we always assign second = curr.
     * Hence, after swapping, the root becomes: [2,3,5,6].
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (pre.val > root.val) {
            if (node1 == null) {
                node1 = pre;
            }
            node2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
