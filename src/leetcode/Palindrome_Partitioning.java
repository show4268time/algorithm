package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * @author: yaoweihao
 * @date: 2019/4/2
 * @time: 17:39
 * @modified by:
 */
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> item = new ArrayList<>();
        partition(s, result, item, 0);
        return result;
    }

    public void partition(String s, List<List<String>> result, List<String> item, int cur) {
        if(cur == s.length()){
            result.add(new ArrayList<>(item));
            return;
        }

        for(int i  = cur; i < s.length(); i++){
            String str = s.substring(cur, i + 1);
            if(isPalindrome(str)){
                item.add(str);
                partition(s, result, item, i + 1);
                item.remove(item.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
            if(s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}
