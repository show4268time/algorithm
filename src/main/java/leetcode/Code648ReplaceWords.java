package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: PhilipFry
 * @create: 2022-08-28 21:35
 * @Description: In English, we have a concept called root,
 * <p>
 * which can be followed by some other word to form another longer word - let's call this word successor.
 * <p>
 * For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
 * <p>
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
 * <p>
 * replace all the successors in the sentence with the root forming it.
 * <p>
 * If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
 * <p>
 * Return the sentence after the replacement.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Example 2:
 * <p>
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 */
public class Code648ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        List<String> res = new ArrayList<>();
        dictionary = dictionary.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < words.length; i++) {
            res.add(getRoot(dictionary, words[i]));
        }

        return res.stream().collect(Collectors.joining(" "));
    }

    private String getRoot(List<String> dictionary, String word) {
        for (int j = 0; j < dictionary.size(); j++) {
            if (isRoot(dictionary.get(j), word)) return dictionary.get(j);
        }
        return word;
    }

    private boolean isRoot(String dic, String word) {
        if (dic.length() > word.length()) return false;
        for (int i = 0; i < dic.length(); i++) {
            if (dic.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }
}
