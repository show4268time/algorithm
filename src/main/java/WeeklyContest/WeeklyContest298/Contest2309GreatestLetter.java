package WeeklyContest.WeeklyContest298;

/**
 * @author: PhilipFry
 * @create: 2022-06-19 12:40
 * @Description: 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * <p>
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * <p>
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 */
public class Contest2309GreatestLetter {
    public String greatestLetter(String s) {
        int[] array = new int[128];
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (array[(char) (c + 32)] >= 1) {
                    if (res.length() > 0) {
                        res = c > res.toCharArray()[0] ? String.valueOf(c) : res;
                    } else {
                        res = String.valueOf(c);
                    }
                }
            } else {
                if (array[(char) (c - 32)] >= 1) {
                    c = (char) (c - 32);
                    if (res.length() > 0) {
                        res = c > res.toCharArray()[0] ? String.valueOf(c) : res;
                    } else {
                        res = String.valueOf(c);
                    }
                }
            }
            array[c]++;
        }
        return res;
    }
}
