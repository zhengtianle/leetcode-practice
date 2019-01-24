package topInterviewQuestionsMedium.dynamicProgramming;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-24
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/106/
 * 零钱兑换
 */
public class Three {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0)
            return -1;

        int[] result = new int[amount+1];//result[i]代表凑齐i元需要最少需要几枚硬币
        Arrays.fill(result, amount+1);//赋值一个比amount大即可
        result[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i >= coin){
                    result[i] = Math.min(result[i], result[i-coin]+1);
                }
            }
        }
        return result[amount] == amount+1 ? -1 : result[amount];
    }
}
