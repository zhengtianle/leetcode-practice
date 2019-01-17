package topInterviewQuestionsMedium.sortingAndSearching;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-17
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/96/
 * 颜色分类
 */
public class First {

    /**
     * 统计0和1的个数然后直接给nums数组赋值
     */
    public void sortColors(int[] nums) {
        int red = 0, white = 0;
        for(int num : nums){
            if(num == 0){
                red++;
            } else if (num == 1){
                white++;
            }
        }

        Arrays.fill(nums,0,red,0);
        Arrays.fill(nums,red,red+white,1);
        Arrays.fill(nums,red+white,nums.length,2);

    }

    /**
     * 双指针法
     * 0放前面
     * 2放后面
     */
    public void sortColors1(int[] nums){
        int left = 0;//从前往后，记录下一个存放0的位置
        int right = nums.length - 1;//从后往前，下一个存放2的位置
        int cur = 0;//遍历元素下标

        while(cur <= right){
            if(nums[cur] == 0){
                nums[cur] = nums[left];
                nums[left] = 0;
                left++;
                cur++;
            } else if (nums[cur] == 1){
                cur++;
            } else {//nums[cur] == 2
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }
}
