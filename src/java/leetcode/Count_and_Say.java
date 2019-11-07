package leetcode;

/**
 * @program: algorithm
 * @description: 计数与报数
 * @author: showtime
 * @create: 2018-09-09 21:31
 **/
public class Count_and_Say {
    public static void main(String[] args){
     int n = 5;
     countAndSay(n);
    }

    public static String countAndSay(int n) {
        if (n < 1) { return ""; }
        if (n == 1) { return "1"; }
        return read(countAndSay(n-1));
    }

    public static String read(String s){
        int cursor = 0;
        int n = 1;

        char c = s.charAt(cursor);
        StringBuilder sb = new StringBuilder();
        while (++cursor < s.length()){
            if (c != s.charAt(cursor)){
                sb = sb.append(Integer.toString(n)).append(c);
                c = s.charAt(cursor);
                n = 1;
            }else {
                n++;
            }
        }
        return sb.append(Integer.toString(n)).append(c).toString();
    }
}
