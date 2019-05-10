package leetcode;

/**
 * @Classname Linked_List_Cycle
 * @Description 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @Date 2019-05-07 16:59
 * @Created by philipfry
 */
public class Linked_List_Cycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head;

        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null){
            if (fast.val == slow.val){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
