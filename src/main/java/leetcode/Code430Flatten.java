package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-08-20 22:51
 * @Description: You are given a doubly linked list, which contains nodes that have a next pointer,
 * <p>
 * a previous pointer, and an additional child pointer.
 * <p>
 * This child pointer may or may not point to a separate doubly linked list,
 * <p>
 * also containing these special nodes. These child lists may have one or more children of their own,
 * <p>
 * and so on, to produce a multilevel data structure as shown in the example below.
 * <p>
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
 * <p>
 * doubly linked list. Let curr be a node with a child list.
 * <p>
 * The nodes in the child list should appear after curr and before curr.next in the flattened list.
 * <p>
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 */
public class Code430Flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) convert(cur);
            cur = cur.next;
        }
        return head;
    }

    private void convert(Node node) {
        Node cur = node;
        Node temp = cur.next;
        Node child = cur.child;
        cur.next = child;
        child.prev = cur;
        cur.child = null;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = temp;
        if (temp != null) temp.prev = cur;
    }
}
