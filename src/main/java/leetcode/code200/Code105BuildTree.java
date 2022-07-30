package leetcode.code200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-05-14 12:01
 * @Description:
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class Code105BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int val = preorder[preStart];
        int mid = map.get(val);
        TreeNode root = new TreeNode(val);

        int leftSize = mid - inStart;

        root.left = build(preorder, inorder, preStart + 1, preStart + leftSize, inStart, mid - 1);
        root.right = build(preorder, inorder, preStart + leftSize + 1, preEnd, mid + 1, inEnd);

        return root;
    }
}
