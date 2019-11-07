package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: showtime
 * @create: 2019-03-10 16:05
 **/
public class Path_Sum_II {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result = pathSum(root, sum, root.val, list, result);
        }

        return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum, int cur, List<Integer> list, List<List<Integer>> result){
        if(root.right == null && root.left == null){
            if(sum == cur){
                result.add(list);
            }
        }

        if(root.left != null){
            List<Integer> leftList = new ArrayList<>(list);
            leftList.add(root.left.val);
            pathSum(root.left, sum, cur + root.left.val, leftList, result);
        }

        if(root.right != null){
            List<Integer> rightList = new ArrayList<>(list);
            rightList.add(root.right.val);
            pathSum(root.right, sum, cur + root.right.val, rightList, result);
        }

        return result;
    }
}
