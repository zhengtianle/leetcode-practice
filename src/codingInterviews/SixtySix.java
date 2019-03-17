package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-17
 * @Author ZhengTianle
 * Description:
 * 机器人的运动范围
 * https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class SixtySix {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return movingCountHelper(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountHelper(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= rows || j < 0 || j >= cols ||
                visited[i][j] ||
                bitSum(i) + bitSum(j) > threshold) {
            return 0;
        }
        visited[i][j] = true;
        return movingCountHelper(threshold, rows, cols, i - 1, j, visited) +
                movingCountHelper(threshold, rows, cols, i + 1, j, visited) +
                movingCountHelper(threshold, rows, cols, i, j - 1, visited) +
                movingCountHelper(threshold, rows, cols, i, j + 1, visited) + 1;
    }

    private int bitSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
