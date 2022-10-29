package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: PhilipFry
 * @create: 2022-10-29 18:34
 * @Description: A sequence x1, x2, ..., xn is Fibonacci-like if:
 * <p>
 * n >= 3
 * xi + xi+1 == xi+2 for all i + 2 <= n
 * Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
 * <p>
 * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 * <p>
 * Input: arr = [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
 */
public class Code873LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        if (arr.length < 3) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }


        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int l = i, r = j;
                int cut = 2;
                while (r < arr.length) {
                    int sum = arr[l] + arr[r];
                    if (map.get(sum) != null) {
                        l = r;
                        r = map.get(sum);
                        cut++;
                        res = Math.max(res, cut);
                    } else {
                        break;
                    }
                }
            }

        }
        return res;
    }
}
