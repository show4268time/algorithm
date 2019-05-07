package leetcode;

/**
 * @program: algorithm
 * @description: 回文链表
 * @author: showtime
 * @create: 2019-03-17 16:14
 **/
public class Palindrome_Linked_List {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

 }
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        isPalindrome(head);

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode previousNode = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = previousNode;
            previousNode = slow;
            slow = next;
        }

        if(fast != null) slow = slow.next;

        while (slow != null && previousNode != null){
            if(slow.val != previousNode.val) return false;
            slow = slow.next;
            previousNode = previousNode.next;
        }
        return true;
    }
}
