package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 判断一个字符串是否是另一个字符串的子串
 * @author: yaoweihao
 * @date: 2018/9/7
 * @time: 16:37
 * @modified by:
 */
public class Implement_strStr {
    public static void main(String[] args){
        String haystack = "mississippi";

        String needle = "issip";
        strStr(haystack, needle);
    }
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        if(haystack.length() == needle.length()){
            if(haystack.equals(needle)){
                return 0;
            }else {
                return -1;
            }
        }
        int nLong = needle.length();
        char s = needle.toCharArray()[0];
        char[] c =  haystack.toCharArray();
        for(int i = 0; i <= c.length - nLong; i++){
            if(c[i] == s){
                if(haystack.substring(i, i + nLong).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
