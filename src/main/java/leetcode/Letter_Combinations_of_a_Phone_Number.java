package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 回溯算法用递归代码非常简洁，逻辑清晰。本质就是一个n叉树的动态规划问题。
 * 每当按下一个新的数字键，之前的任何一种可能，马上衍生出n种可能。
 * 用递归，就是每层都递归调用n次。
 * @author: yaoweihao
 * @date: 2018/9/15
 * @time: 15:41
 * @modified by:
 */
public class Letter_Combinations_of_a_Phone_Number {
    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

    }

    /**
     * n叉树的遍历，用递归非常简洁
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;

        char[] chars = digits.toCharArray();
        letterCombinationsRecursive(result, "", map, 0, chars);
        return result;
    }

    private void letterCombinationsRecursive(List<String> result, String str, Map<Character, String> map, int index, char[] chars){
        if(index == chars.length) {
            result.add(str);
            return;
        }
        if(map.get(chars[index]) == null){
            letterCombinationsRecursive(result, str, map, index + 1, chars);
        }else {
            for(char c : map.get(chars[index]).toCharArray()){
                letterCombinationsRecursive(result, str + c, map, index + 1, chars);
            }
        }
    }
}
