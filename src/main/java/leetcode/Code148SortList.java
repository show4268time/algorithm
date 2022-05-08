package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: PhilipFry
 * @create: 2022-05-07 11:50
 * @Description: Given the head of a linked list, return the list after sorting it in ascending order
 */
public class Code148SortList {
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

    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        if(collect.size() == 1){
            return head;
        }
        ListNode cur = new ListNode();
        sortList(cur, collect, 0);
        return cur;
    }

    public void sortList(ListNode head, List<Integer> collect, int i) {
        head.val =  collect.get(i);
        if(i + 1 < collect.size()){
            ListNode node = new ListNode();
            head.next = node;
            i++;
            sortList(node, collect, i);
        }
    }
}
