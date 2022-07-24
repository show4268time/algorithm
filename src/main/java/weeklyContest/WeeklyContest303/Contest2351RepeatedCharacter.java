package weeklyContest.WeeklyContest303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-07-24 13:41
 * @Description:
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 *
 * Note:
 *
 * A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 * s will contain at least one letter that appears twice.
 */
public class Contest2351RepeatedCharacter {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(set.contains(c)){
                return c;
            }
            set.add(c);
        }
        return 'a';
    }
}
