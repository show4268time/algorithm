package leetcode.code200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-05-14 12:01
 * @Description: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
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

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int lStart, int lEnd, int rStart, int rEnd) {
        if (lStart > lEnd) return null;

        TreeNode node = new TreeNode(preorder[lStart]);
        int n = map.get(preorder[lStart]);
        int r = rEnd - n;
        int l = n - rStart;
        node.left = dfs(preorder, inorder, lStart + 1, lStart + l, rStart, n - 1);
        node.right = dfs(preorder, inorder, lStart + l + 1, lEnd, n + 1, n + r);
        return node;

    }
}
