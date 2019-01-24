package topInterviewQuestionsMedium.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-24
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/107/
 * Longest Increasing Subsequence
 */
public class Four {
    //O(n²)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        //result[i]表示从第一个元素到此元素，包含此元素的最长递增子序列长度
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    result[i] = Math.max(result[j]+1,result[i]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i] > max)
                max = result[i];
        }
        return max;
    }

    /**
     * O(n*log(n))
     * 迭代判断每个数num将其插入dp数组相应的位置
     * 如果此时1,3,5,7。下一个出现4，那么发现3<4<5，则把5换成4。（此时最长递增子序列仍然是1 3 5 7）
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];//dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数
        int len = 0;//最长递增子序列长度
        int low;
        int high;
        int mid;
        for(int num : nums){
            low = 0;
            high = len;//取不到
            while(low < high){
                mid = (low + high)/2;
                if(dp[mid] < num)
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = num;
            if(low == len)
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.lengthOfLIS1(new int[]{2,5,3,7,8}));
    }
}
