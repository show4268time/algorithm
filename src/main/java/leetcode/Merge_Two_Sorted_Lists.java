package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 合并两个已排序的链表
 * @author: yaoweihao
 * @date: 2018/9/6
 * @time: 15:01
 * @modified by:
 */
public class Merge_Two_Sorted_Lists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if(listNode1 == null) return listNode2;
        if(listNode2 == null) return listNode1;

        ListNode l1 = listNode1;
        ListNode l2 = listNode2;
        ListNode listNode = null;
        ListNode listNodeStart = null;
        ListNode temp = null;
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            if (listNode == null) {
                listNode = temp;
                listNodeStart = listNode;
            } else {
                listNode.next = temp;
                listNode = listNode.next;
            }
        }

        if (l1 == null) listNode.next = l2;
        if (l2 == null) listNode.next = l1;

        return listNodeStart;
    }

}
