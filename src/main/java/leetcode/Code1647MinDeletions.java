package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-06-28 23:06
 * @Description: A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string.
 * <p>
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
public class Code1647MinDeletions {
    public int minDeletions(String s) {
        int[] n = new int[128];
        Arrays.fill(n, -1);
        for(int i = 0; i<s.length(); i++){
            n[s.charAt(i)]++;
        }
        Arrays.sort(n);
        int res = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 127; i >=0;i--){
            if(n[i] != -1){
                int num = n[i] + 1;
                if (map.get(num) != null) {
                    while (map.get(num) != null) {
                        num--;
                        res++;
                    }
                }
                if(num != 0) map.put(num, true);
            }else{
                break;
            }
        }
        return res;
    }
}
