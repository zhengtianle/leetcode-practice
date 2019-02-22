package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-22
 * @Author ZhengTianle
 * Description:
 * 跳台阶
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Eight {
    public int JumpFloor(int target) {
        if(target == 0 || target == 1 || target == 2) {
            return target;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
