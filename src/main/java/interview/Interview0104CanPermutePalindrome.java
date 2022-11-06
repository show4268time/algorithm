package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-11-06 19:03
 * @Description: 面试题 01.04. 回文排列
 * 简单
 * 93
 * 相关企业
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class Interview0104CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        int cut = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) {
                if (++cut > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
