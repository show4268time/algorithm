package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-23 17:48
 * @Description: Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 */
public class Code206ReverseList {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode l = head, r = head.next;
        while (r != null) {
            ListNode n = r.next;
            r.next = l;
            l.next = null;
            l = r;
            r = n;
        }
        return l;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
