package interview;

/**
 * @author: PhilipFry
 * @create: 2022-11-13 20:53
 * @Description: 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 */
public class Interview0402SortedArrayToBST {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = left + right >> 1;

        TreeNode l = sortedArrayToBST(nums,  left, mid - 1);
        TreeNode r = sortedArrayToBST( nums,  mid + 1, right);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = l;
        node.right = r;
        return node;
    }
}
