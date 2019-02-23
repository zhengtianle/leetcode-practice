package codingInterviews;


/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-23
 * @Author ZhengTianle
 * Description:
 * 变态跳台阶
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking3
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Nine {
    public int JumpFloorII(int target) {
        if(target == 0 || target == 1 || target == 2) {
            return target;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }

    /**
     * 简化：
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *
     *     可以得出：
     *
     *     f(n) = 2*f(n-1)
     */
    public int JumpFloorIII(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorIII(target - 1);
        }
    }
}
