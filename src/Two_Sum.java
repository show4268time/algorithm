import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author: yaoweihao
 * @date: 2018/9/3
 * @time: 10:58
 * @modified by:
 */
public class Two_Sum {

    public static void main(String[] args) {
        twoSumLogN(new int[]{2, 7, 11, 15}, 9);
    }

    /**
     * 两层迭代方法 时间复杂度是log(n2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 空间换时间。用Map存下以前遇到过的值
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumLogN(int[] nums, int target){
        if (nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
