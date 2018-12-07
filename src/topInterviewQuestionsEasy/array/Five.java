package topInterviewQuestionsEasy.array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-10
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 */
public class Five {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        boolean repeat = false;
        int i;
        for(i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) {
                repeat = true;
            } else {
                if(repeat == false){
                    break;
                } else {
                    repeat = false;
                }
            }
        }

        return nums[i - 1];
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }
}
