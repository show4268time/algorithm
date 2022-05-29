package WeeklyContest.BiweeklyContest79;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-05-29 07:51
 * @Description: You have a chat log of n messages.
 * You are given two string arrays messages and senders where messages[i] is a message sent by senders[i].
 * A message is list of words that are separated by a single space with no leading or trailing spaces.
 * The word count of a sender is the total number of words sent by the sender.
 * Note that a sender may send more than one message.
 * Return the sender with the largest word count.
 * If there is more than one sender with the largest word count, return the one with the lexicographically largest name.
 * Note:
 * Uppercase letters come before lowercase letters in lexicographical order.
 * "Alice" and "alice" are distinct.
 */
public class Contest2284LargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        String result = "";
        int max = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String message = messages[i];
            String[] strings = message.split(" ");
            String sender = senders[i];
            if (countMap.containsKey(sender)) {
                countMap.put(sender, countMap.get(sender) + strings.length);
            } else {
                countMap.put(sender, strings.length);
            }
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                result = entry.getKey();
                max = entry.getValue();
            } else if (count == max) {
                String key = entry.getKey();
                if (result.compareTo(key) < 0) {
                    result = key;
                }
            }
        }
        return result;
    }
}
