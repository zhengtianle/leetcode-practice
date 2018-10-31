package simple;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 * Author: ZhengTianle
 */
public class SevenZero {
    public static int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for(int i = 1;i < 50;i++){
            System.out.println("输入：" + i + "  输出：" + climbStairs(i));
        }
    }
}
