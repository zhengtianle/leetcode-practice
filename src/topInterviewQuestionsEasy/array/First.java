package topInterviewQuestionsEasy.array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-8
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 */
public class First {

    public static int removeDuplicates(int[] nums) {
        //先排序
        Arrays.sort(nums);

        int len = 1;    //记录非重复数组的长度/非重复数组中下一个元素的下标
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[len] = nums[i];
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
