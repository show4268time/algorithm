package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 当有边界情况需要特殊处理的时候，加一个哨兵sentinel，会让特殊情况的逻辑一般化，代码更加整洁
 * @author: yaoweihao
 * @date: 2018/9/17
 * @time: 9:39
 * @modified by:
 */
public class Remove_Nth_Node {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode before = head;
        ListNode node = head;
        ListNode listNode = head;
        ListNode after = head;
        int i = 1;
        while (node != null) {
            if (i == n) {
                before = head;
                listNode = head;
                after = head.next;
            } else if (i > n) {
                before = listNode;
                listNode = listNode.next;
                after = listNode.next;
            }
            node = node.next;
            i ++;
        }
        i = i - 1;
        if (i < n) return null;

        if(i == n) return after;
        if(i > n) {
            before.next = after;
            return head;
        }
        return null;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode slow = null, fast = sentinel;
        int cursor = 0; // index of fast
        while (fast != null) {
            fast = fast.next;
            if (slow != null) { slow = slow.next; }
            if (cursor - n == 0) { slow = sentinel; } // slow和fast之间间隔n格距离
            cursor++;
        }
        if (slow != null) {
            slow.next = slow.next.next;
        }
        return sentinel.next;
    }
}
