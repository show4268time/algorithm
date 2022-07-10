package weeklyContest.WeeklyContest301;

/**
 * @author: PhilipFry
 * @create: 2022-07-10 14:48
 * @Description: You are given two strings start and target, both of length n.
 * <p>
 * Each string consists only of the characters 'L', 'R', and '_' where:
 * <p>
 * The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left,
 * and a piece 'R' can move to the right only if there is a blank space directly to its right.
 * The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
 * Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.
 */
public class Contest2337CanChange {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int j = 0;
        for (int i = 0; i < n; i++) {
            char sc = start.charAt(i);
            if (sc == '_') continue;
            while (j < n && target.charAt(j) == '_') j++;
            if (j == n) return false;
            if (sc != target.charAt(j)) return false;
            if (sc == 'L' && i < j) return false;
            if (sc == 'R' && i > j) return false;
            j++;
        }
        for (int i = j; j < n; j++) {
            if (target.charAt(j) != '_') {
                return false;
            }
        }
        return true;
    }
}
