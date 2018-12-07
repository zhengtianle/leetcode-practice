package random.difficult;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/dungeon-game/description/
 * Author: ZhengTianle
 */
public class OneSevenFour {

    public static int calculateMinimumHP(int[][] dungeon) {
        /**
         * dp[i][j]代表未经过dungeon[i][j]
         */
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for(int i = m - 2; i >= 0; i--){
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] -  dungeon[m - 1][i]);
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n -2; j >= 0; j--){
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];

        /**
         * 假设向右走是最优路
         * dp[p][q] + dungeon[p + 1][q] = dp[p + 1][q]
         * dp[p][q] = dp[p +1][q] - dungeon[p +1][q]
         *
         * 求dp[0][0] - dungeon[0][0]
         */
        /*int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;
        for(int i = m - 2; i >= 0; i--){
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i + 1][n - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] -  dungeon[m - 1][i + 1]);
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n -2; j >= 0; j--){
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j] - dungeon[i + 1][j], dp[i][j + 1] - dungeon[i][j + 1]));
            }
        }

        return dp[0][0] - dungeon[0][0];*/
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{
                {100}
        }));
    }
}
