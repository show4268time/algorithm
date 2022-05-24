package leetcode.code150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 09:46
 * @Description: Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * <p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * A leaf is a node with no children.
 */
public class Code113PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> backtrack = new LinkedList<>();
        pathSum(root, sum, backtrack);

        return result;
    }

    public void pathSum(TreeNode node, int sum, LinkedList<Integer> backtrack) {
        if(node == null) return;

        if(node.left == null && node.right == null){
            if(node.val == sum){
                backtrack.addLast(node.val);
                result.add(new ArrayList<>(backtrack));
                backtrack.removeLast();
            }else{
                return;
            }
        }

        backtrack.addLast(node.val);
        pathSum(node.left, sum - node.val, backtrack);
        backtrack.removeLast();

        backtrack.addLast(node.val);
        pathSum(node.right, sum - node.val, backtrack);
        backtrack.removeLast();

    }
}
