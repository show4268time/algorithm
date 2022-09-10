package offer.II;

import java.util.Stack;

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
        if(head == null) return new int[0];
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        int n = st.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = st.pop();
        }
        return res;
    }


    public int[] reversePrint1(ListNode head) {
        if(head == null) return new int[0];
        ListNode node = back(head);
        int[] res = new int[n];
        for(int i = 0; i< n; i++){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }

    private ListNode back(ListNode node){
        ListNode pre = null;
        while(node != null){
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
            n++;
        }
        return pre;
    }
}
