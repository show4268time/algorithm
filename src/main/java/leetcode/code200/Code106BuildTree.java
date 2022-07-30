package leetcode.code200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-05-14 22:48
 * @Description: Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class Code106BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd) {
        if (inStart > inEnd) return null;
        int val = postorder[posEnd];
        int index = map.get(val);
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(val);


        root.left = build(inorder, inStart, index - 1, postorder, posStart, posStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, posStart + leftSize, posEnd + 1);
        return root;
    }
}
