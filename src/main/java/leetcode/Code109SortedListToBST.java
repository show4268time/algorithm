package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-19 20:07
 * @Description: Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.  For this problem,
 * a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 */
public class Code109SortedListToBST {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {

        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode mid = getMid(head, end);
        TreeNode node = new TreeNode(mid.val);
        node.left = build(head, mid);
        node.right = build(mid.next, end);

        return node;

    }

    private ListNode getMid(ListNode head, ListNode end) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
