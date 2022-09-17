package leetcode.code200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-09-17 22:41
 * @Description: A linked list of length n is given such that each node contains an additional random pointer,
 * <p>
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list.
 * <p>
 * The deep copy should consist of exactly n brand new nodes,
 * <p>
 * where each new node has its value set to the value of its corresponding original node.
 * <p>
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
 * <p>
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.  The linked list is represented in the input/output as a list of n nodes.
 * <p>
 * Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * <p>
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * <p>
 * or null if it does not point to any node. Your code will only be given the head of the original linked list.
 */
public class Code138CopyRandomList {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node res = new Node(-1);
        Node pre = null;
        Node cur = head;

        while (cur != null) {
            Node node = new Node(cur.val);
            if (pre != null) {
                pre.next = node;
            } else {
                res.next = node;
            }
            map.put(cur, node);
            pre = node;
            cur = cur.next;
        }

        cur = head;
        Node n = res.next;
        while (cur != null) {
            if (cur.random != null) {
                n.random = map.get(cur.random);
            }
            cur = cur.next;
            n = n.next;
        }
        return res.next;
    }
}
