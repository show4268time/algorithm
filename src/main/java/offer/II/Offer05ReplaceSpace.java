package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-08-09 23:30
 * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer05ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
