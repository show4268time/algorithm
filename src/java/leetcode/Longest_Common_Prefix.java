package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author: yaoweihao
 * @date: 2018/9/5
 * @time: 20:02
 * @modified by:
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if (strs.length == 1) { return strs[0]; }

        for(int i = 0; i < strs[0].length(); i ++){
            for(int n = 1; n < strs.length; n ++){
                if(i >= strs[n].length() || strs[0].charAt(i) != strs[n].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
