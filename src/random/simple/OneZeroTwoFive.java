package random.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-3
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/divisor-game/
 * 1025. 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 *
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 *
 * 提示：
 *
 * 1 <= N <= 1000
 */
public class OneZeroTwoFive {
    public boolean divisorGame(int N) {
        /**
         * 奇数操作完一定是偶数
         * 偶数操作完可能是奇数也可能是偶数
         * 最后谁拿到2谁赢
         * 如果一直给对面奇数，那么就一定赢
         * 只有第一次操作的时候是偶数才有可能一直给对面奇数
         * 爱丽丝先手，所以N为偶数时，就赢，奇数时便输（假设对面也知道怎么玩必赢）
         */
        return (N & 1) == 0;
    }
}
