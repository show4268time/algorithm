package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最长无重复子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: yaoweihao
 * @date: 2018/9/10
 * @time: 14:19
 * @modified by:
 */
public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "aab";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        int fastCursor = 0;
        int slowCursor = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (fastCursor < s.length()) {
            if (!set.contains(s.charAt(fastCursor))) {
                set.add(s.charAt(fastCursor++));
                max = Math.max(max,set.size());
            } else {
                set.remove(s.charAt(slowCursor++));
            }
        }
        return max;
    }
}
