package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-05-10 09:47
 * @Description: Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Code19RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode listNode = findFromEnd(sentinel, n + 1);
        if (listNode != null) {
            listNode.next = listNode.next.next;
        }

        return sentinel.next;
    }

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
