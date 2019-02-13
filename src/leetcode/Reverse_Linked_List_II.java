package leetcode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
 * @author: yaoweihao
 * @date: 2019/2/13
 * @time: 20:43
 * @modified by:
 */
public class Reverse_Linked_List_II {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        reverseBetween(listNode1, 1, 2);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) { return head; }
        ListNode sentinel = new ListNode(0), wall = sentinel;
        sentinel.next = head;
        for (int i = 1; i < m; i++) {
            wall = wall.next;
        } // 确保wall点是m点左边的第一个点。m为head时，wall等于开头的sentinel
        ListNode left = wall.next, right = left.next; // right为要向前插的点，left是它的前一点
        for (int i = m + 1; i <= n; i++) { // assert: n > m
            left.next = right.next; //-|
            right.next = wall.next; //-| >>> 这四步前插动作是本题的关键
            wall.next = right;      //-|
            right = left.next;      //-|
        }
        return sentinel.next;
    }
}
