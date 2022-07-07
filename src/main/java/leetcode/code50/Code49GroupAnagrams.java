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
        int n = strs.length;
        boolean[] used = new boolean[n];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            List<String> list = new ArrayList<>();
            used[i] = true;
            list.add(strs[i]);
            int k = strs[i].length();
            String str = strs[i];
            int[] array = new int[128];
            for (int w = 0; w < k; w++) {
                array[str.charAt(w)]++;
            }
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                if (strs[j].length() == k) {
                    if (check(array, strs[j])) {
                        list.add(strs[j]);
                        used[j] = true;
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    private boolean check(int[] array, String str) {
        int n = str.length();
        int[] other = new int[128];
        for (int i = 0; i < n; i++) {
            other[str.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            if (other[str.charAt(i)] != array[str.charAt(i)]) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        //判断是否为空字符串数组
        if(strs == null || strs.length == 0){
            return new ArrayList();
        }
        //1.创建一个哈希表
        Map<String,List> map = new HashMap<String, List>();
        for (String s: strs) {
            //将字符串转化为字符数组
            char[] chars = s.toCharArray();
            //对字符数组按照字母顺序排序
            Arrays.sort(chars);
            //将排序后的字符串作为哈希表中的key值
            String key = String.valueOf(chars);
            //2.判读哈希表中是否有该key值
            if (!map.containsKey(key)){
                //若不存在，则为新的异位词语，在map中创建新的键值对
                map.put(key,new ArrayList());
            }
            //3.将该字符串放在对应key的list中
            map.get(key).add(s);
        }
        //返回map中所有键值对象构成的list
        return new ArrayList(map.values());
    }
}
