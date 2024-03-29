package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-17 23:55
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 *  
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class Offer36TreeToDoublyList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node node) {
        if (node == null) return null;

        dfs(node);
        Node l = node;
        while (l.left != null) {
            l = l.left;
        }

        Node r = node;
        while (r.right != null) {
            r = r.right;
        }

        l.left = r;
        r.right = l;
        return l;
    }

    public Node dfs(Node node) {
        if (node == null) return null;

        Node left = dfs(node.left);
        node.left = left;
        if (left != null) left.right = node;
        Node right = dfs(node.right);

        if (right != null) {
            Node cur = right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = node;
            node.right = cur;
            return right;
        } else {
            return node;
        }
    }
}
