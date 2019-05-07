package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 两两交换节点
 * @author: yaoweihao
 * @date: 2018/9/19
 * @time: 15:18
 * @modified by:
 */
public class Swap_Nodes_Pairs {
     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode temp ;
        ListNode cursor  = new ListNode(1);
        cursor.next = head;
        ListNode listNode = head.next;
        while (cursor != null && cursor.next != null && cursor.next.next != null){
            temp = cursor.next.next;
            cursor.next.next = temp.next;
            temp.next = cursor.next;
            cursor.next = temp;
            cursor = cursor.next.next;
        }
         return listNode;
    }
}
