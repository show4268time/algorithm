package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: PhilipFry
 * @create: 2022-08-06 10:55
 * @Description: 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 */
public class Interview0403ListOfDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tree);

        while (q.size() > 0) {
            int length = q.size();
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = q.poll();
                if (treeNode.left != null) q.offer(treeNode.left);
                if (treeNode.right != null) q.offer(treeNode.right);

                ListNode node = new ListNode(treeNode.val);
                cur.next = node;
                cur = cur.next;
            }
            list.add(head.next);
        }

        ListNode[] res = new ListNode[list.size()];
        return list.toArray(res);
    }
}
