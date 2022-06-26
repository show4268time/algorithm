package weeklyContest.WeeklyContest294;

/**
 * @author: PhilipFry
 * @create: 2022-05-22 14:37
 * @Description: Given a string s and a character letter,
 * return the percentage of characters in s that equal letter rounded down to the nearest whole percent.
 */
public class Contest2278PercentageLetter {
    public int percentageLetter(String s, char letter) {
        char[] chars = s.toCharArray();
        double count = 0;
        for (char c : chars) {
            if (c == letter) {
                count++;
            }
        }
        return (int) (count / s.length() * 100);
    }
}
