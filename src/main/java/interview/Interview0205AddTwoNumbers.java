package interview;

/**
 * @author: PhilipFry
 * @create: 2022-11-13 17:42
 * @Description:
 */
public class Interview0205AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mod = 0;
        ListNode cur = new ListNode(-1);
        ListNode sentinel = cur;
        while (l1 != null || l2 != null || mod != 0) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + mod;
            ListNode node = new ListNode(val % 10);
            mod = val / 10;
            cur.next = node;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return sentinel.next;
    }
}
