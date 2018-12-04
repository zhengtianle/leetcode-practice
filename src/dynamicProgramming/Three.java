package dynamicProgramming;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-4
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 */
public class Three {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int updateSum = nums[i] + sum;
            //继续加进来还是从当前从新开始
            sum = updateSum > nums[i] ? updateSum : nums[i];
            if(ans < sum)
                ans = sum;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
