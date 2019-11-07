package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * @author: yaoweihao
 * @date: 2019/4/8
 * @time: 15:02
 * @modified by:
 */
public class Copy_List_with_Random_Pointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val,null, null);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        node = head;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }

        Node newHead = head.next;
        node = head;
        while (node != null) {
            Node newNode = node.next;
            node.next = newNode.next;
            if (newNode.next != null)
                newNode.next = newNode.next.next;
            node = node.next;
        }
        return newHead;
    }
}
