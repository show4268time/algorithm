package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-08-09 23:42
 * @Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Offer06ReversePrint {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int l = 0;

    public int[] reversePrint(ListNode head) {
        ListNode node = reverse(head);
        int[] res = new int[l];
        int i = 0;
        while (node != null) {
            res[i] = node.val;
            node = node.next;
            i++;
        }
        return res;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
            l++;
        }
        return pre;
    }
}
