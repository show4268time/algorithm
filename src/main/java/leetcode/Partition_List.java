package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * @author: yaoweihao
 * @date: 2018/12/13
 * @time: 16:28
 * @modified by:
 */
public class Partition_List {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        partition(listNode1, 3);
    }
    public static ListNode partition(ListNode head, int x) {
        if(head== null || head.next == null) return head;
        ListNode listNode = new ListNode(0);
        ListNode small = null;
        ListNode tempSmall = null;
        ListNode big = null;
        ListNode tempBig = null;


        while (head != null) {
            if (head.val < x) {
                if (small == null) {
                    small = head;
                    tempSmall = small;
                } else {
                    small.next = head;
                    small = small.next;
                }
            } else {
                if(big == null){
                    big = head;
                    tempBig = big;
                }else {
                    big.next = head;
                    big = big.next;
                }
            }
            head = head.next;
        }
        if(small != null) small.next = null;


        if(big != null) big.next = null;
        if (tempSmall != null) {
            listNode.next = tempSmall;
            small.next = tempBig;
        }else {
            listNode.next = tempBig;
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
