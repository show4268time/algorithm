package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 最后一个单词的长度
 * @author: yaoweihao
 * @date: 2018/10/22
 * @time: 14:58
 * @modified by:
 */
public class Length_Of_Last_Word {
    public static void main(String[] args){
        String s = " a";
        lengthOfLastWord(s);
    }
    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();

        int longth = 0;
        int i = chars.length - 1;
        while (i >=0){
            if(longth == 0 && chars[i] == ' '){
                i--;
            }else if (chars[i] != ' ') {
                longth++;
                i--;
            }else {
                break;
            }
        }

        if(i == 0 && chars[0] != ' '){
            longth = chars.length;
        }
        return longth;
    }
}
