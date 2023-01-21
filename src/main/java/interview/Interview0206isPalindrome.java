package interview;

/**
 * @author: PhilipFry
 * @create: 2023-01-22 00:07
 * @Description: 解题思路：
 * <p>
 * 利用快慢双指针找到链表中间节点
 * 然后反转后半部分链表
 * 依次比较前半部分和后半部分的值
 * 举例：
 * 链表偶数长度：1->2->2->1,找到中点,为倒数第二个节点2，即后半部分为2->1，反转得到1->2,然后两部分从头比较值即可
 * 链表奇数长度：1->2->3->2->1,中点3，即后半部分为3->2->1,反转得到1->2->3,然后从头比较，当前半部分到空时，1和2已经比较完，这时就退出了循环，因为剩一个节点3，不影响是否回文
 * 这道题是好题，做会这道题，相当于做了三道，学会了反转链表，找链表中点，以及判断回文链表，强烈推荐
 */
public class Interview0206isPalindrome {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = findMid(head);

        ListNode l1 = head;
        ListNode l2 = reverse(mid);
        while (l1 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    private ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node, p = null;
        while (fast != null && fast.next != null) {
            p = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        p.next = null;
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
