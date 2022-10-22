package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-10-22 00:07
 * @Description: Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 */
public class Code875MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = (int) 1e9;

        while (l < r) {
            int mid = l + r >> 1;
            if (check(piles, h, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }


    private boolean check(int[] piles, int h, int n) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += Math.ceil(piles[i] * 1.0 / n);
        }
        return count <= h;
    }
}
