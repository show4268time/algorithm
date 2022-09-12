package leetcode.code50;

/**
 * @author: PhilipFry
 * @create: 2022-05-07 11:23
 * @Description: You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class Code21MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode();
        mergeTwoLists(list1, list2, cur);
        return cur.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            } else {
                if (list1.val <= list2.val) {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            cur = cur.next;
        }
        return sentinel.next;
    }

    public void mergeTwoLists(ListNode list1, ListNode list2, ListNode cur) {
        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        } else {
            if (list1.val >= list2.val) {
                ListNode next = new ListNode(list2.val);
                cur.next = next;
                mergeTwoLists(list1, list2.next, cur.next);
            } else {
                ListNode next = new ListNode(list1.val);
                cur.next = next;
                mergeTwoLists(list1.next, list2, cur.next);
            }
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    cur.next = list2;
                    list2 = list2.next;
                } else {
                    cur.next = list1;
                    list1 = list1.next;
                }
            } else if (list1 != null) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
