package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 填充每个节点的下一个右侧节点指针
 * @author: showtime
 * @create: 2019-03-11 21:26
 **/
public class Populating_Next_Right_Pointers_in_Each_Node {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root != null){
            List<List<Node>> result = new ArrayList<>();
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);
            while (nodes.size() > 0){
                List<Node> list = new ArrayList<>();
                for(int i = nodes.size(); i > 0; i--){
                    Node node = nodes.poll();
                    list.add(node);
                    if(node.right != null) nodes.add(node.right);
                    if(node.left != null) nodes.add(node.left);
                }
                result.add(list);
            }

            for(int i = 0; i < result.size(); i++){
                List<Node> list = result.get(i);
                Node temp = null;
                for(Node node : list){
                    node.next = temp;
                    temp = node;
                }
            }
        }

        return root;
    }

}
