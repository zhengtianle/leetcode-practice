package topInterviewQuestionsHard.dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-4-25
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/155/
 * Best Time to Buy and Sell Stock with Cooldown
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Second {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        //dp1[i]表示第i天手上有股票的最大收益（前i天的最后一个状态是买入）
        int[] dp1 = new int[prices.length];
        //dp2[i]表示第i天卖出股票的最大收益
        int[] dp2 = new int[prices.length];
        //dp3[i]表示前i天最后一个状态为冷冻期的最大收益（第i天要么无状态即冷冻期后没有再买入，要么为冻结状态）
        int[] dp3 = new int[prices.length];

        dp1[0] = 0 - prices[0];
        for(int i = 1; i < prices.length; i++) {
            //第i天买入股票：dp3[i - 1] - prices[i]（dp3[i - 1]表明今天可以买）
            //第i天不买入股票：dp1[i - 1]
            dp1[i] = Math.max(dp3[i - 1] - prices[i], dp1[i - 1]);
            //第i天卖出股票
            dp2[i] = dp1[i - 1] + prices[i];
            //第i天为冷冻期：代表第i-1天卖出股票->dp2[i - 1]
            //第i天为无状态：dp3[i- 1]
            dp3[i] = Math.max(dp2[i - 1], dp3[i - 1]);
        }
        //1.最后一天卖出
        //2.最后一天为冷冻期
        //3.最后一天无状态（冷冻期后没有再买入）
        return Math.max(dp2[prices.length - 1], dp3[prices.length - 1]);
    }
}
