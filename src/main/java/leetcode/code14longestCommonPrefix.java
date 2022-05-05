package main.java.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class code14longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int length = Integer.MAX_VALUE;
        for(String str : strs){
            length = Math.min(str.length(), length);
        }
        for (int i = 0 ; i < length; i ++){
            String pre = "";
            for(String str : strs){
                String substring = str.substring(i, i + 1);
                if("".equals(pre)){
                    pre = substring;
                }else {
                    if(!pre.equals(substring)){
                        return res;
                    }
                }
            }
            res = res + pre;
        }
        return res;
    }
}
