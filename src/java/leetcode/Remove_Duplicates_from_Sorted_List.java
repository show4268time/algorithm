package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author: yaoweihao
 * @date: 2018/12/12
 * @time: 21:14
 * @modified by:
 */
public class Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        deleteDuplicates(listNode1);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;
        ListNode slow = new ListNode(Integer.MAX_VALUE);
        ListNode listNode = slow;

        while (fast != null) {
            int slowVal = slow.val;
            int fastVal = fast.val;

            if (slowVal == fastVal) {
                slow.next = null;
            } else {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        return listNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
