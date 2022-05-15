package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-14 09:00
 * @Description: You are given an integer array nums with no duplicates.
 * A maximum binary tree can be built recursively from nums using the following algorithm:
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 */
public class Code654ConstructMaximumBinaryTree {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return traverse(nums, 0, nums.length - 1);
    }

    public TreeNode traverse(int[] nums, int start, int end) {
        if (start > end) return null;

        int max = Integer.MIN_VALUE;
        int mid = start;
        for (int index = start; index <= end; index++) {
            if (nums[index] > max) {
                mid = index;
                max = nums[index];
            }
        }
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = traverse(nums, start, mid - 1);
        treeNode.right = traverse(nums, mid + 1, end);

        return treeNode;
    }
}
