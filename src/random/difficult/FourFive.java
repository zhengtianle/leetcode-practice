package random.difficult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-23
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45. 跳跃游戏 II
 */
public class FourFive {
    /**
     * 贪心
     * 可到达的最远处为当前可达的所有位置能到的最远处
     */
    public int jump(int[] nums) {
        int steps = 0;//跳了几步
        int canReach = 0;//当前可达最远范围
        int max = 0;//已经走过的所有节点，再跳一次能到多远
        for(int i = 0; i < nums.length; i++){
            if(canReach < i){//当前不可以达到这一位置
                steps++;//需要跳一次，跳数++
                canReach = max;//跳一次
            }
            max = Math.max(max, i+nums[i]);
        }
        return steps;
    }
}
