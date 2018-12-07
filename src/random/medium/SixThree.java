package random.medium;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 * Author: ZhengTianle
 */
public class SixThree {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];//1...m  1...n

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1){
                    dp[i][j] = (obstacleGrid[0][0] == 0?1:0);
                    continue;
                }
                if(obstacleGrid[i - 1][j - 1] == 1)//0...m-1  0...n-1
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {1}
        }));
    }
}

