package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @author: yaoweihao
 * @date: 2018/10/24
 * @time: 19:43
 * @modified by:
 */
public class Rotate_List {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        rotateRight(listNode1, 1);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        ListNode listNode = head;
        ListNode result ;
        ListNode last = head;

        int n = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            n++;
        }
        k = k % n;

        if(k == 0){
            return head;
        }else {
            int num = n - k;
            ListNode temp = head;
            while (num > 0) {
                temp = temp.next;
                num--;
                if(num == 1){
                    last = temp;
                }
            }
            result = temp;
            listNode.next = head;
            last.next = null;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
