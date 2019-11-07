package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author: yaoweihao
 * @date: 2018/9/10
 * @time: 10:06
 * @modified by:
 */
public class Add_Two_Numbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int i = 0;
        while (l1 != null || l2 != null){
            int count1 = l1 == null ? 0 : l1.val;
            int count2 = l2 == null ? 0 : l2.val;
            ListNode listNode = new ListNode((count1 + count2 + i) % 10);
            temp.next = listNode;
            temp = temp.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            i = (count1 + count2 + i) / 10;
        }
        if(i != 0){
            ListNode listNode = new ListNode(i);
            temp.next = listNode;
        }
        return result.next;
    }
}
