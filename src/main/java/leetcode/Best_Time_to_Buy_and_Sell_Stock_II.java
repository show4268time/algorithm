package leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @description:  买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author: yaoweihao
 * @date: 2019/3/14
 * @time: 13:32
 * @modified by:
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        maxProfit(prices);
    }
    public static int maxProfit(int[] prices) {
        int buy = 0, sell = 0, profit = 0;
        if(prices.length > 0){
            while (sell+1 < prices.length) { // 偷看明天的价格，决定今天卖不卖
                if (prices[sell+1] <= prices[sell]) {
                    profit += (prices[sell] - prices[buy]);
                    sell++; buy = sell;
                } else {
                    sell++;
                }
            }
            profit += (prices[sell] - prices[buy]);
        }
        return profit;
    }
}
