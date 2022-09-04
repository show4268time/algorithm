package offer.Ⅰ;

/**
 * @author: PhilipFry
 * @create: 2022-06-26 22:53
 * @Description: 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 */
public class Offer91MinCost {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] r = new int[n + 1];
        int[] g = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            r[i] = costs[i - 1][0] + Math.min(g[i - 1], b[i - 1]);
            b[i] = costs[i - 1][1] + Math.min(r[i - 1], g[i - 1]);
            g[i] = costs[i - 1][2] + Math.min(r[i - 1], b[i - 1]);
        }
        return Math.min(r[n], Math.min(b[n], g[n]));
    }
}
