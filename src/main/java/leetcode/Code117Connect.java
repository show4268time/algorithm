package leetcode;

import java.util.LinkedList;

/**
 * @author: PhilipFry
 * @create: 2022-05-20 15:22
 * @Description: Given a binary tree
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 */
public class Code117Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        LinkedList<Node> backtrack = new LinkedList<>();
        backtrack.offer(root);
        connect(backtrack);
        return root;
    }

    private void connect(LinkedList<Node> backtrack) {
        if (backtrack.isEmpty()) return;
        LinkedList<Node> nextLevel = new LinkedList<>();
        Node temp = new Node(-666);

        for (int i = backtrack.size(); i > 0; i--) {
            Node node = backtrack.poll();
            if (temp.val != -666) {
                temp.next = node;
            }
            if (node.left != null) nextLevel.offer(node.left);
            if (node.right != null) nextLevel.offer(node.right);
            temp = node;
        }
        connect(nextLevel);
    }
}
