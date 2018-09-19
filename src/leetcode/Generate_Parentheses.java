package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 强化回溯算法的思维方式。把每个方案抽象成一系列小决策的组合。经典的锯钢条问题把据钢条的方案抽象成在每个可以切割的点选择“切”或者“不切”。
 * 这题可以抽象成在每个点可以选择写一个右括号关闭之前还没有关闭的左括号，也可以选择新开一个左括号。 这样就可以把问题转化成n叉树问题。
 * @author: yaoweihao
 * @date: 2018/9/17
 * @time: 19:24
 * @modified by:
 */
public class Generate_Parentheses {
    /**
     * 回溯算法的本质就是n叉树。尤其像每一步都有n种选择的问题，不遍历每一种情况，很难找出答案。这时候就要用到回溯算法。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        generate(n, 0, "", list);
        return list;
    }

    public void generate(int left, int right, String str, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }

        if (right > 0) {
            generate(left, right - 1, str + ")", list);
            generate(left - 1, right + 1, str + "(", list);
        }
        if (left > 0) {
            generate(left - 1, right + 1, str + "(", list);
        }
    }
}
