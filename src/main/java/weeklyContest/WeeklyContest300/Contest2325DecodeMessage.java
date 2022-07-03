package weeklyContest.WeeklyContest300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-07-03 14:04
 * @Description: You are given the strings key and message, which represent a cipher key and a secret message,
 * <p>
 * respectively. The steps to decode message are as follows:
 * <p>
 * Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
 * Align the substitution table with the regular English alphabet.
 * Each letter in message is then substituted using the table.
 * Spaces ' ' are transformed to themselves.
 * For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet),
 * we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
 * Return the decoded message.
 */
public class Contest2325DecodeMessage {
    char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (set.contains(c) || c == ' ') {
                continue;
            }
            map.put(c, chars[count]);
            set.add(c);
            count++;
        }
        String res = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                res += " ";
            } else {
                res += map.get(c);
            }
        }

        return res;
    }
}
