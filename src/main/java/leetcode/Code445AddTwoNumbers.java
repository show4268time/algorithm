package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-20 16:36
 * @Description: You are given two non-empty linked lists representing two non-negative integers.
 * <p>
 * The most significant digit comes first and each of their nodes contains a single digit.
 * <p>
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Code445AddTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = reverse(l1);
        ListNode q = reverse(l2);
        int t = 0;
        ListNode cur = null;
        while (q != null || p != null || t != 0) {
            int n = (q == null ? 0 : q.val) + (p == null ? 0 : p.val) + t;
            ListNode node = new ListNode(n % 10);
            t = n / 10;
            node.next = cur;
            cur = node;
            if (q != null) q = q.next;
            if (p != null) p = p.next;
        }
        return cur;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}
