package leetcode;


/**
 * Created with IntelliJ IDEA
 *
 * @description: 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 * @author: yaoweihao
 * @date: 2018/12/11
 * @time: 14:17
 * @modified by:
 */
public class Remove_Duplicates_from_Sorted_List_II {

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode temp = new ListNode(0);
        ListNode listNode = temp;
        temp.next = head;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            int slowVal = slow.val;
            int fastVal = fast.val;

            if (slowVal == fastVal) {
                count++;
                temp.next = null;
                if (fast.next == null && count == 1) {
                    temp.next = fast;
                }
                fast = fast.next;
            } else {
                if (count == 1) {
                    temp.next = slow;
                    temp = temp.next;
                    slow = fast;
                    count = 0;
                } else {
                    count = 0;
                    slow = fast;
                }
            }
        }
        return listNode.next;
    }
}
