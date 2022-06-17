package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: PhilipFry
 * @create: 2022-06-17 21:31
 * @Description: 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
 * <p>
 * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 */
public class Code1048LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] dp = new int[words.length + 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (check(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    private boolean check(String a, String b) {
        if (a.length() != b.length() + 1) return false;
        int i = 0;
        for (Character c : a.toCharArray()) {
            if (i < b.length() && c == b.charAt(i)) {
                i++;
            }
        }
        return i == b.length();
    }
}
