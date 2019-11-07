package leetcode;

/**
 * @program: algorithm
 * @description: 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author: showtime
 * @create: 2019-03-10 09:45
 **/
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public TreeNode sortedListToBST(ListNode head) {

        return sortedListToBST(head, null);
    }


    public TreeNode sortedListToBST(ListNode start, ListNode end){
        if(start == end) return null;
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(start, slow);
        root.right = sortedListToBST(slow.next, end);
        return root;
    }
}
