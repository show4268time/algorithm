package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @author: yaoweihao
 * @date: 2018/10/9
 * @time: 14:41
 * @modified by:
 */
public class Group_Anagrams {
    public static void main(String[] args){
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String[] strss = strs.clone();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (map.get(new String(chars)) == null) {
                List<String> list = new ArrayList<>();
                list.add(strss[i]);
                map.put(new String(chars), list);
            } else {
                map.get(new String(chars)).add(strss[i]);
            }
        }
        for(List<String> list : map.values()){
            result.add(list);
        }
        return result;
    }
}
