package leetcode;

/**
 * @program: algorithm
 * @description: 经典题目百位大数
 * @author: showtime
 * @create: 2018-10-04 16:21
 **/
public class Multiply_Strings {
    public static void main(String[] args){
        String num1 = "123";
        String num2 = "456";
        multiply(num1, num2);
    }
    public static String multiply(String num1, String num2) {
        String result = "0";
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        for(int i = chars1.length - 1; i > -1; i--){
            int plus = 0;
            StringBuilder sb = new StringBuilder();
            int n1 = chars1[i] - '0';

            for(int j = chars2.length - 1; j > -1; j--){
                int n2 = chars2[j] - '0';
                int res = n1 * n2 + plus;

                sb.insert(0, res % 10);
                plus = res / 10;
            }

            if(plus> 0){
                sb.insert(0,plus);
            }

            if(sb.charAt(0) != '0'){
                for(int k = 0; k< chars1.length - 1 - i; k++){
                    sb.append("0");
                }
                result = Add(sb.toString(), result);
            }


        }

        return result;
    }

    public static String Add(String str, String result){
        StringBuilder sb = new StringBuilder();
        int plus = 0;
        for(int i = str.length() - 1, j = result.length() - 1; i >= 0 || j >= 0; j--, i--){
            int num1 = 0, num2 = 0;
            if(i >=0) num1 = str.charAt(i) - '0';
            if(j >= 0) num2 = result.charAt(j) - '0';

            int res = num1 + num2 +plus;
            sb.insert(0, (res % 10));
            plus = res /10;
        }
        if(plus > 0) sb.insert(0, plus);
        System.out.println(str + " + " + result + " = " + sb.toString());
        return sb.toString();
    }
}
