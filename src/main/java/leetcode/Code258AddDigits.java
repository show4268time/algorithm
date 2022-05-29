package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-05-29 19:05
 * @Description: Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class Code258AddDigits {
    public int addDigits(int num) {
        if(num / 10 == 0) return num;

        int temp = num;
        int number = 0;
        while(temp > 0 ){
            number = number + temp % 10;
            temp = temp / 10;
        }
        return addDigits(number);
    }
}
