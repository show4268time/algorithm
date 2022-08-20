package leetcode.code200;

/**
 * @author: PhilipFry
 * @create: 2022-08-20 14:52
 * @Description: Given the head of a linked list, return the node where the cycle begins.
 * <p>
 * If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * <p>
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
 * <p>
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 */
public class Code142DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
