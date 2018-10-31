package medium;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/unique-paths/description/
 * Author: ZhengTianle
 */
public class SixTwo {
    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[1], 1);//第一行赋值为1
        for(int i = 2; i <= n; i++){//第一列赋值为1
            dp[i][1] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= m; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[n][m];
        /*return uniquePaths(m-1,n)+uniquePaths(m,n-1);*/
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
