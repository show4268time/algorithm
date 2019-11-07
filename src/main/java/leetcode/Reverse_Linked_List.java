package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 反转一个单链表
 * @author: yaoweihao
 * @date: 2019/2/14
 * @time: 9:57
 * @modified by:
 */
public class Reverse_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        reverseList(listNode1);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        while (head != null && head.next != null){
            ListNode next = head.next;
            head.next = next.next;
            next.next = sentinel.next;
            sentinel.next = next;
        }
        return sentinel.next;
    }
}
