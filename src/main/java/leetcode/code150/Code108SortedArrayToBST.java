package leetcode.code150;

/**
 * @author: PhilipFry
 * @create: 2022-05-19 12:08
 * @Description: Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class Code108SortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);

        return node;
    }
}
