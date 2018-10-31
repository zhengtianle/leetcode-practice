package medium;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/contest/weekly-contest-108/problems/minimum-falling-path-sum/
 * Author: ZhengTianle
 */
public class NineThreeOne {

    public static int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A.length];
        dp[0] = Arrays.copyOf(A[0], A.length);
        for(int i = 1; i < A.length; i++){  //从第二行到最后一行
            for(int j = 0; j < A.length; j++){  //每一行从第一列到最后一列
                if(j == 0){ //第一列
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if(j == A.length - 1){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                } else{
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + A[i][j];
                }
            }
        }

        Arrays.sort(dp[A.length - 1]);
        return dp[A.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{
                {-51}
        }));
    }
}
