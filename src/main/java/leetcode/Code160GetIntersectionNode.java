package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-24 14:35
 * @Description:
 */
public class Code160GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode q = headA, p = headB;
        while (p != q) {
            q = (q == null) ? headB : q.next;
            p = (p == null) ? headA : p.next;
        }
        return q;
    }
}
