package offer;

/**
 * @author: PhilipFry
 * @create: 2022-08-09 23:30
 * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer05ReplaceSpace {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' '){
                res.append("%20");
            } else{
                res.append(chars[i]);
            }

        }
        return res.toString();
    }
}
