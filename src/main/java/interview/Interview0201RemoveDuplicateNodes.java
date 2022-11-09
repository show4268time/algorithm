package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-11-09 22:00
 * @Description:
 */
public class Interview0201RemoveDuplicateNodes {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        Set<Integer> set = new HashSet<>();
        sentinel.next = head;
        ListNode pre = sentinel;
        while (head != null) {
            if (set.contains(head.val)) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            set.add(head.val);
            head = head.next;
        }
        return sentinel.next;
    }
}
