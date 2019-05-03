package random.medium;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-3
 * @Author ZhengTianle
 * Description:
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class NineOne {
    boolean flag = true;
    public int numDecodings(String s) {
        /**
         * 第一种方法，深度优先遍历
         * 1. 把当前字符串的第一个字符单独解码，然后计算后面的字符串的解码数
         * 2. 把当前字符串的第一个和第二个字符放在一起解码，然后计算后面的字符串的解码数
         *
         * 超出时间限制
         * 最后执行的输入："1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"
         */
        if(s == null || s.length() <= 0) return 0;
        if(s.contains("00")) {
            flag = false;
            return 0;
        }
        if(s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if(s.length() ==2) {
            int ans = 0;
            //两个数字每个数组单独解码
            if(s.charAt(0) != '0' && s.charAt(1) != '0') ans += 1;
            //合体
            if(s.charAt(0) != '0' && Integer.valueOf(s) <= 26) ans += 1;
            return ans;
        }

        int ans = 0;
        //第一个数字单独解码
        if(s.charAt(0) != '0') ans += numDecodings(s.substring(1));
        //第一个数字和第二个数字组成一个数字解码
        if(s.charAt(0) != '0' && Integer.valueOf(s.substring(0,2)) <= 26) ans += numDecodings(s.substring(2));
        return ans;
    }

    public int numDecodings1(String s) {
        /**
         * 第二种解法：动态规划
         * dp[i] 表示前i个字符一共有几种解码数
         * 转移方程是 dp[i] = dp[i - 1] + dp[i - 2];
         * 原因是dp[i]一定由以下两种状态转移而来
         * 1. 前 i - 1 个字符解码后，第 i 个字符单独解码 -> dp[i - 1]
         * 2. 前 i - 2 个字符解码后，第 i - 1 和第 i 个字符合并解码 -> dp[i - 2]
         */
        if(s == null || s.length() <= 0) return 0;
        if(s.contains("00")) return 0;
        int[] dp = new int[s.length()];
        if(s.charAt(0) != '0') dp[0] = 1;
        if(s.length() >= 2) {
            if(s.charAt(0) != '0' && s.charAt(1) != '0') dp[1]++;
            if(s.charAt(0) != '0' && Integer.valueOf(s.substring(0, 2)) <= 26) dp[1]++;
        }
        for(int i = 2; i < s.length(); i++) {
            if(s.charAt(i) != '0') dp[i] = dp[i - 1];//单独
            if(s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) dp[i] += dp[i - 2];//合体
        }
        return dp[s.length() - 1];
    }
}
