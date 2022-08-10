package offer;

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

    int n = 0;

    public int[] reversePrint(ListNode head) {
        ListNode node = back(head);
        int[] res = new int[n];
        int i = 0;
        while (node != null) {
            res[i] = node.val;
            node = node.next;
            i++;
        }
        return res;
    }

    private ListNode back(ListNode node) {
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            n++;
        }
        return pre;
    }
}
