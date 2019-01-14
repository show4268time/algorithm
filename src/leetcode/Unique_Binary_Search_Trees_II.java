package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 不同的二叉搜索树 II
 * @author: yaoweihao
 * @date: 2019/1/14
 * @time: 9:23
 * @modified by:
 */
public class Unique_Binary_Search_Trees_II {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public static void main(String[] args){
        generateTrees(3);
  }
    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) { return new ArrayList<TreeNode>(); }
        return recursive(1,n);
    }

    public static List<TreeNode> recursive(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) { res.add(null); return res; } // must have null
        for (int index = start; index <= end; index++) {
            List<TreeNode> leftSubTree = recursive(start,index-1);
            List<TreeNode> rightSubTree = recursive(index+1,end);
            for (TreeNode ln : leftSubTree) {
                for (TreeNode rn : rightSubTree) {
                    TreeNode root = new TreeNode(index);
                    root.left = ln;
                    root.right = rn;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
