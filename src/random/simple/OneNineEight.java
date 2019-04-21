package random.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-26
 * @Author ZhengTianle
 * Description:
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/submissions/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class OneNineEight {
    //0 1 背包问题
    //
    public int rob(int[] nums) {
        if(nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        //抢劫0、1房屋能带来的最高金额
        //抢第0个房屋
        dp[0] = nums[0];
        if(nums.length == 1) {
            return dp[0];
        }
        //抢第1个房屋
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            //不抢劫这个房屋，抢劫的金额等于抢劫前一个房屋之后得到的最高金额
            //抢劫这个房屋，则前一个房屋不可抢劫，于是金额等于抢劫前一个的前一个房屋的最高金额+抢劫此房屋的金额
            //取其中较大者
            //dp[i]表示抢劫0-i房屋能带来的最高金额（不是0-i的房屋每一个都抢劫，而是当只有0-i的房屋时，题目所求的最高金额为多少）
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
