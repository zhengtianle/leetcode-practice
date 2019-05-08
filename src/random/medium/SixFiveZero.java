package random.medium;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-7
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/2-keys-keyboard/
 * 650. 只有两个键的键盘
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 * 说明:
 *
 * n 的取值范围是 [1, 1000] 。
 */
public class SixFiveZero {
    int result = Integer.MAX_VALUE;

    public int minSteps(int n) {
        minStepsHelper(1, n, 0, 0);
        return result;
    }

    //深搜
    private void minStepsHelper(int cur, int n, int steps, int copy) {
        if(cur == n) {
            result = steps < result ? steps : result;
            return ;
        }
        if(cur > n) return ;
        if(copy == 0) {
            //copy all
            minStepsHelper(cur, n, steps+1, cur);
        } else if(copy == cur) {
            //paste
            minStepsHelper(cur + copy, n, steps+1, copy);
        } else {
            //copy != 0 && copy != cur
            //有两种选择，要么paste，要么copy all
            //copy all
            minStepsHelper(cur, n, steps+1, cur);
            //paste
            minStepsHelper(cur + copy, n, steps+1, copy);
        }
    }


    //动态规划
    public int minSteps1(int n) {
        if(n == 1) return 0;

        int result = n;
        for(int i = 2; i <= n/2; i++) {
            //因数
            if(n % i == 0) {
                result = Math.min(result, minSteps1(i) + n/i);
            }
        }
        return result;
    }
}
