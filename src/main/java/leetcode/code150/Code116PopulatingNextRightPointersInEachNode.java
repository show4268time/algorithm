package leetcode.code150;

/**
 * @author: PhilipFry
 * @create: 2022-05-13 23:25
 * @Description: You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class Code116PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node left, Node right) {
        if (left == null || right == null) return;
        left.next = right;

        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }
}
