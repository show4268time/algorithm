package leetcode;

/**
 * @program: algorithm
 * @description: 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * @author: showtime
 * @create: 2019-03-09 17:13
 **/
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder,0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] in , int inStart, int inEnd, int[] post, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;

        int rootVal =  post[postEnd] ;
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(in, inStart, rootIndex - 1, post, postStart , postStart + len -1);
        root.right = buildTree(in, rootIndex + 1, inEnd, post, postStart + len, postEnd - 1);

        return root;
    }
}
