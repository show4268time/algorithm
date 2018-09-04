/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * @author: yaoweihao
 * @date: 2018/9/3
 * @time: 18:43
 * @modified by:
 */
public class Reverse_Integer {
    public static void main(String[] args){
        int x = -956;
        reverse1(x);
    }
    public static int reverse(int x) {
        //先转成String
        String number = String.valueOf(x);
        //String没有反转的方法，但是StringBuilder有
        StringBuilder builder = new StringBuilder(number).reverse();
        //反转后判断是否为负数
        if(builder.charAt(builder.length() - 1) == '-'){
            //删掉最后一位
            builder.deleteCharAt(builder.length() - 1);
            //在第一位加上 -
            builder.insert(0, '-');
        }
        //转成long  防止溢出
        long longNum = Long.parseLong(builder.toString());
        return (longNum < (long)Integer.MIN_VALUE || longNum > (long)Integer.MAX_VALUE) ? 0 : (int)longNum;
    }

    public static int reverse1(int x){
        long result = 0l;
        while (x != 0){
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        return (result < (long)Integer.MIN_VALUE || result > (long)Integer.MAX_VALUE) ? 0 : (int)result;
    }
}
