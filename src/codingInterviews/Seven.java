package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-22
 * @Author ZhengTianle
 * Description:
 * 斐波那契数列
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Seven {
    public int Fibonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int[] result = new int[40];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
}
