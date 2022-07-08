package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-21 09:43
 * @Description: Given the root of a binary tree,
 * imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class Code199RightSideView {
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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return result;

        LinkedList<TreeNode> backtrack = new LinkedList<>();
        backtrack.offer(root);

        rightSideView(backtrack);

        return result;
    }

    public void rightSideView(LinkedList<TreeNode> backtrack) {
        if (backtrack.isEmpty()) return;
        int size = backtrack.size();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            TreeNode cur = backtrack.poll();
            if (i == 0) {
                result.add(cur.val);
            }
            if (cur.right != null) nextLevel.offer(cur.right);
            if (cur.left != null) nextLevel.offer(cur.left);

        }
        rightSideView(nextLevel);
    }
}
