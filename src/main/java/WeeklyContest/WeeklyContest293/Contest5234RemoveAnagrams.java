package WeeklyContest.WeeklyContest293;

import java.util.*;

/**
 * @author: PhilipFry
 * @create: 2022-05-15 10:30
 * @Description: You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.
 * In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words.
 * Keep performing this operation as long as you can select an index that satisfies the conditions.  Return words after performing all operations.
 * It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once.
 * For example, "dacb" is an anagram of "abdc".
 */
public class Contest5234RemoveAnagrams {
    public static void main(String[] args) {
        String[] words = new String[]{"z","z","z","gsw","wsg","gsw","krptu"};

        removeAnagrams(words);
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        String mark = words[0];
        char[] chars = mark.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        result.add(words[0]);
        Arrays.sort(chars);

        for (int index = 0; index < chars.length; index++) {
            if (map.get(chars[index]) == null) {
                map.put(chars[index], 1);
            } else {
                map.put(chars[index], map.get(chars[index]) + 1);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            char[] charArray = word.toCharArray();
            Map<Character, Integer> hashMap = new HashMap<>();
            for (int index = 0; index < charArray.length; index++) {
                if (hashMap.get(charArray[index]) == null) {
                    hashMap.put(charArray[index], 1);
                } else {
                    hashMap.put(charArray[index], hashMap.get(charArray[index]) + 1);
                }
            }
            Boolean is = Boolean.FALSE;

            if (hashMap.size() == map.size()) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (map.get(entry.getKey()) == null) {
                        is = Boolean.TRUE;
                        break;
                    } else if (!map.get(entry.getKey()).equals(entry.getValue())) {
                        is = Boolean.TRUE;
                        break;
                    }
                }
                if (is) {
                    map = hashMap;
                    result.add(word);
                }
            }else {
                map = hashMap;
                result.add(word);
            }
        }

        return result;
    }
}
