package offer.II;

/**
 * @author: PhilipFry
 * @create: 2022-09-24 19:37
 * @Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 */
public class Offer66ConstructArr {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int w = 1;
        for (int i = 0; i < a.length; i++) {
            res[i] = w;
            w *= a[i];
        }

        w = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] *= w;
            w *= a[i];
        }
        return res;
    }
}
