package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 要打破单向遍历的思维习惯。
 * 在一个有序数列上，双向查找（bi-directional 2Sum sweep），也可以叫Two Pointers，的复杂度是O(n)，比两层套嵌遍历的O(n2)有效很多。
 * @author: yaoweihao
 * @date: 2018/9/14
 * @time: 9:00
 * @modified by:
 */
public class Three_Sum {
    public static void main(String[] args){
        int[] nums = new int[]{-2,0,0,2,2};
        threeSum(nums);
    }
    /**
     * 数组先排序。遍历数组，获得第一个数，剩下两个数用双向查找，搜索和为一定值的两个数。
     * 查找过程，先在数组首尾分别设置一个指针。当两个指针指向的值的和小于第一个数的相反数，低位指针左移，否则，高位指针右移。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        //先排序再找
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    listList.add(list);
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right - 1 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
                if (nums[i] + nums[left] + nums[right] > 0) {
                    while (left < right - 1 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return listList;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int main = 0;
        while (main < nums.length - 2) {
            if (nums[main] > 0) {
                break;
            }
            int low = main + 1;
            int high = nums.length - 1;
            while (low < high) {
                long sum = (long) (nums[main] + nums[low] + nums[high]);
                if (sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[main], nums[low], nums[high]})));
                }
                if (sum <= 0) {
                    while (low + 1 < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;
                }
                if (sum >= 0) {
                    while (low < high - 1 && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                }
            }
            while (main + 1 < nums.length - 2 && nums[main] == nums[main + 1]) {
                main++;
            }
            main++;
        }
        return result;
    }

}
