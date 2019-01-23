package topInterviewQuestionsMedium.dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-23
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/104/
 * 跳跃游戏
 */
public class First {
    //贪心
    //从后往前遍历
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)
            return true;
        int step = 1;
        //最后一个元素不用遍历
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= step){//到最后一个位置转换成可以到i位置处即可，因为i可以到最后一个位置
                step = 1;
            } else {//此处不可达
                step++;
            }
        }
        return step == 1;
    }
}
