package offer.II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-09-17 22:02
 * @Description:
 */
public class Offer34PathSum {
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

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, 0, path);
        return res;
    }

    private void dfs(TreeNode node, int target, int sum, LinkedList<Integer> path) {
        if (node == null) return;

        sum += node.val;
        path.addLast(node.val);
        if (node.left == null && node.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
        }

        if (node.left != null) dfs(node.left, target, sum, path);
        if (node.right != null) dfs(node.right, target, sum, path);
        path.removeLast();
    }
}
