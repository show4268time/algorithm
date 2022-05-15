package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-05-09 22:54
 * @Description: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.  A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class Code17LetterCombinations {
    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty() || digits == "") {
            return result;
        }

        letterCombinations("", 0, digits.toCharArray(), result);
        return result;
    }

    public void letterCombinations(String pre, int i, char[] chars, List<String> result) {
        if (i == chars.length) {
            result.add(pre);
           return ;
        }

        if (map.get(chars[i]) == null) {
             letterCombinations(pre, i+1, chars, result);
        } else {
            String s = map.get(chars[i]);
            for (char c : map.get(chars[i]).toCharArray()) {
                letterCombinations(pre + c, i + 1, chars, result);
            }
        }
    }

}
