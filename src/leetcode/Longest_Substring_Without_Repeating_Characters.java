package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最长无重复子串
 * @author: yaoweihao
 * @date: 2018/9/10
 * @time: 14:19
 * @modified by:
 */
public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args){
        String s = "aab";
        lengthOfLongestSubstring(s);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        char[] c = s.toCharArray();

        String pre = "";
        String p = "";
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            List<Character> list = new ArrayList<>();
            sb.append(c[i]);
            list.add(c[i]);
            for (int j = i + 1; j < s.length(); j++) {
                if (!list.contains(c[j])) {
                    sb.append(c[j]);
                    list.add(c[j]);
                    p = sb.toString();
                } else {
                    p = sb.toString();
                    break;
                }
            }
            if(pre.length() < p.length()){
                pre = p;
            }
        }
        return pre.length() > p.length() ? pre.length() : p.length();
    }
}
