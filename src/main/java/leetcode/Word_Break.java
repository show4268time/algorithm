package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 *       拆分时可以重复使用字典中的单词。
 *       你可以假设字典中没有重复的单词。
 * @author: yaoweihao
 * @date: 2019/4/12
 * @time: 9:57
 * @modified by:
 */
public class Word_Break {
    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        String s = "leetcode";
        wordBreak(s, wordDict);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        boolean[] memo = new boolean[size + 1];
        memo[0] = true;
        for(int i = 0; i < size + 1; ++i){
            for(int j = 0; j < i; ++j){
                if(memo[j] && wordDict.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[size];
    }
}
