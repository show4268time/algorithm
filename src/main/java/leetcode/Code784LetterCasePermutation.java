package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: PhilipFry
 * @create: 2022-10-30 18:57
 * @Description: Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. Return the output in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * <p>
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 */
public class Code784LetterCasePermutation {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        dfs(s, "", 0);
        return res;
    }

    private void dfs(String s, String pre, int index) {
        if (index == s.length()) {
            res.add(pre);
            return;
        }

        char c = s.charAt(index);
        dfs(s, pre + c, index + 1);
        if (c >= 'a' && c <= 'z') {
            c -= 32;
            dfs(s, pre + c, index + 1);
        } else if (c >= 'A' && c <= 'Z') {
            c += 32;
            dfs(s, pre + c, index + 1);
        }
    }
}
