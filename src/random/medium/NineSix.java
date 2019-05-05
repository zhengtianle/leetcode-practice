package random.medium;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class NineSix {

    public int numTrees(int n) {
        /**
         * 设定f(n)表示n个节点组成的二叉搜索树有多少种
         * 则包括以下几种情况：
         * 以1为根节点：左子树有0个节点，右子树有n-1个节点
         * 以2为根节点：左子树有1个节点，右子树有n-2个节点
         * ……
         * 以n为根节点：左子树有n-1个节点，右子树有0个节点
         * 即f(n) = f(0)*f(n-1) + f(1)f(n-2) + …… + f(n-1)f(0);
         * 目前已知f(0) = 1，f(1) = 1，可以推出f(2) = f(0)f(1) + f(1)f(0);
         * 进而推出f(3)，f(4) …… f(n)
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //每次大循环求f(i)
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                //左边 j 个，右边 i - j - 1 个
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
