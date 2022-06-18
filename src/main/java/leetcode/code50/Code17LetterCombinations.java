package leetcode.code50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-05-09 22:54
 * @Description: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.  A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class Code17LetterCombinations {
    List<String> res = new ArrayList<>();
    String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        back("", 0, digits);
        return res;
    }

    private void back(String pre, int index, String digits) {
        if (index == digits.length()) {
            res.add(pre);
            return;
        }

        char c = digits.charAt(index);
        String str = phone[c - '0'];
        if (str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                String s = pre + str.charAt(i);
                back(s, index + 1, digits);
            }
        } else {
            back(pre, index + 1, digits);
        }
    }
}
