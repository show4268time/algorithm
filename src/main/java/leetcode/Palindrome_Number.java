package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 判断一个整数是否是回文数，不要使用额外的空间
 * @author: yaoweihao
 * @date: 2018/9/4
 * @time: 10:11
 * @modified by:
 */
public class Palindrome_Number {
    public static boolean isPalindrome(int x) {
        //负数不是回文数
        if(x < 0){
            return false;
        }
        int num = 0;
        int oldX = x;
        //把数字逆转
        while (x != 0){
            num = num * 10 + x % 10;
            x = x / 10;
        }
        //判断两个数是否一致
        return num == oldX;
    }

    /**
     * 更给力的办法  只逆转一半，但是以零结尾的数字不符合
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int num = 0;
        while (x > num){
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return x == num || x == num / 10;
    }
}
