package leetcode;

/**
 * @program: algorithm
 * @description: 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * @author: showtime
 * @create: 2019-03-09 10:43
 **/
public class Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};

        buildTree(preorder, inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){

        if(inStart > inEnd || preStart > preEnd){
            return  null;
        }

        int rootVal = pre[preStart];

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
        root.right = buildTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);


        return root;
    }
}
