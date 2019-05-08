package random.medium;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-8
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class SevenOneFour {

    //卖出的时候有手续费fee
    public int maxProfit(int[] prices, int fee) {
        //buy[i]表示第i天手上还有股票的最大收益
        int[] buy = new int[prices.length];
        //sell[i]表示第i天卖出手上的股票的最大收益
        int[] sell = new int[prices.length];
        //none[i]表示前i天已经把股票卖出了，之后没有再操作的最大收益
        int[] none = new int[prices.length];
        //答案应该是sell[prieces.length - 1]或者none[prices.length - 1]

        //第一天肯定需要买入，循环从第二天开始
        buy[0] = 0 - prices[0];
        for(int i = 1; i < prices.length; i++) {
            //第i天买入则第i-1天是sell或者none；第i天不买入，则buy[i] = buy[i - 1]
            buy[i] = Math.max(Math.max(none[i - 1], sell[i - 1]) - prices[i], buy[i - 1]);
            //第i天卖出股票，手里必须有股票
            sell[i] = buy[i] + prices[i] - fee;
            //第i天为无状态，则第i-1天必须是无状态或者是卖出状态
            none[i] = Math.max(none[i - 1], sell[i - 1]);
        }
        return Math.max(sell[prices.length - 1], none[prices.length - 1]);
    }
}
