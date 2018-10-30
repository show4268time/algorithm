package leetcode;


/**
 * Created with IntelliJ IDEA
 *
 * @description: 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author: yaoweihao
 * @date: 2018/10/29
 * @time: 19:50
 * @modified by:
 */
public class Plus_One {
    public int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();
        int plus = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if(i == digits.length - 1){
                plus = 1;
            }
            int num = plus + digits[i];
            sb.insert(0, num % 10);
            plus = num / 10;
        }
        if (plus != 0){
            sb.insert(0, plus);
        }

        int[] result = new int[sb.toString().length()];
        for(int l = 0; l < result.length; l ++){
            result[l] = new Integer(sb.toString().substring(l, l+ 1));
        }
        return result;
    }
}
