package leetcode;

/**
 * @author: PhilipFry
 * @create: 2022-07-02 13:19
 * @Description: You are assigned to put some amount of boxes onto one truck.
 * <p>
 * You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * <p>
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * <p>
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
 * <p>
 * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * <p>
 * Return the maximum total number of units that can be put on the truck.
 */
public class Code1710MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] n = new int[1001];
        int length = boxTypes.length;
        for (int i = 0; i < length; i++) {
            int num = boxTypes[i][1];
            int count = boxTypes[i][0];
            n[num] += count;
        }
        int res = 0;
        for (int i = 1000; i >= 0; i--) {
            if (n[i] != 0) {
                if (truckSize >= n[i]) {
                    res += i * n[i];
                    truckSize -= n[i];
                } else {
                    res += i * truckSize;
                    break;
                }
            }
        }
        return res;
    }
}
