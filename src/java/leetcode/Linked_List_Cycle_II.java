package leetcode;

/**
 * @Classname Linked_List_Cycle_II
 * @Description 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * @Date 2019-09-06 19:49
 * @Created by philipfry
 */
public class Linked_List_Cycle_II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        int pos = 0;

        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        ListNode listNode = null;

        while (fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                listNode = fast;
                break;
            }
            pos ++;
        }

        if(listNode == null) return null;

        ListNode cur = head, cycleCur = listNode;
        while (cur != cycleCur) {
            cur = cur.next;
            cycleCur = cycleCur.next;
        }
        return cur;
    }
}
