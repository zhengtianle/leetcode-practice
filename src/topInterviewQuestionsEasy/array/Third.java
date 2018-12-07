package topInterviewQuestionsEasy.array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-9
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 */
public class Third {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length-k);
        for(int i = 0; i < k; i++){
            nums[i] = nums[nums.length - k + i];
        }
        for(int i = k; i < nums.length; i++){
            nums[i] = temp[i - k];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
