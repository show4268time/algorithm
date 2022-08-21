package leetcode.code50;

import java.util.*;

/**
 * @author: PhilipFry
 * @create: 2022-07-07 23:11
 * @Description: 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class Code49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (used[j]) continue;
                if (check(strs[i], strs[j])) {
                    list.add(strs[j]);
                    used[j] = true;
                }
            }
            res.add(list);
        }
        return res;
    }

    private boolean check(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        //判断是否为空字符串数组
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        //1.创建一个哈希表
        Map<String, List> map = new HashMap<String, List>();
        for (String s : strs) {
            //将字符串转化为字符数组
            char[] chars = s.toCharArray();
            //对字符数组按照字母顺序排序
            Arrays.sort(chars);
            //将排序后的字符串作为哈希表中的key值
            String key = String.valueOf(chars);
            //2.判读哈希表中是否有该key值
            if (!map.containsKey(key)) {
                //若不存在，则为新的异位词语，在map中创建新的键值对
                map.put(key, new ArrayList());
            }
            //3.将该字符串放在对应key的list中
            map.get(key).add(s);
        }
        //返回map中所有键值对象构成的list
        return new ArrayList(map.values());
    }
}
