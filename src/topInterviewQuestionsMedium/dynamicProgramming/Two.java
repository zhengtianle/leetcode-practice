package topInterviewQuestionsMedium.dynamicProgramming;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-23
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/105/
 * 不同路径
 */
public class Two {

    //迭代
    public int uniquePaths(int m, int n) {//n行m列
        if(m == 1 || n == 1)
            return 1;
        int[][] dp = new int[n+1][m+1];//0不用
        //第一列第一行赋值为1
        Arrays.fill(dp[1], 1);
        for(int i = 1; i <= n; i++){
            dp[i][1] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][m];
    }

    //递归
    public int uniquePaths1(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        return uniquePaths1(m-1, n) + uniquePaths1(m, n-1);
    }
}
