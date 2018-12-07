package random.simple;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/description/
 * Author: ZhengTianle
 */
public class SevenFourSix {

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = {0, 0};

        for(int i = 2;i <= cost.length; i++){
            int temp = dp[1];
            //dp[i]代表“到达”第i层所需最小花费--不包含cost[i]本身的花费
            dp[1] = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
            dp[0] = temp;
        }

        return dp[1];

    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}

