package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-06-12 15:07
 * @Description: GivØen a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
 * <p>
 * A word matches the pattern if there exists a permutation (置换) of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 * <p>
 * Recall that a permutation (置换) of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
 */
public class Code890FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean check(String word, String pattern) {
        Map<Character, Character> wMap = new HashMap<>();
        Map<Character, Character> pMap = new HashMap<>();
        if (word.length() != pattern.length()) {
            return false;
        }

        int i = 0;
        boolean res = true;
        while (i < pattern.length()) {
            if (wMap.containsKey(pattern.charAt(i)) && wMap.get(pattern.charAt(i)) != word.charAt(i)) {
                res = false;
                break;
            }
            if (pMap.containsKey(word.charAt(i)) && pMap.get(word.charAt(i)) != pattern.charAt(i)) {
                res = false;
                break;
            }
            wMap.put(pattern.charAt(i), word.charAt(i));
            pMap.put(word.charAt(i), pattern.charAt(i));
            i++;
        }
        return res;
    }
}
