/**
 * Created with IntelliJ IDEA
 *
 * @description:
 * @author: yaoweihao
 * @date: 2018/9/5
 * @time: 20:02
 * @modified by:
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if (strs.length == 1) { return strs[0]; }
        int strMinLong = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i ++){
            strMinLong = Math.min(strs[i].length(), strMinLong);
        }

        for(int i = 0; i < strMinLong; i ++){
            char c = strs[0].charAt(i);
            for(int n = 0; n < strs.length; n ++){
                if(c != strs[n].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, strMinLong);
    }
}
