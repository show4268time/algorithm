package interview;

/**
 * @author: PhilipFry
 * @create: 2022-11-12 16:34
 * @Description: 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class Interview0202KthToLast {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode pre = head, cur = head;

        while (cur != null) {
            if (k > 0) {
                k--;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return pre.val;
    }
}
