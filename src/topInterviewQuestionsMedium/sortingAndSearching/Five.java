package topInterviewQuestionsMedium.sortingAndSearching;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-21
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/100/
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Five {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right && (nums[left] != target || nums[right] != target)){
            mid = (left + right) / 2;
            if(target > nums[mid])
                left = mid + 1;
            else if (target < nums[mid])
                right = mid - 1;
            else if(nums[right] != target)
                right--;
            else if(nums[left] != target)
                left++;
        }
        if(left < nums.length && right > -1 && nums[left] == target)
            return new int[]{left,right};
        else
            return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(Arrays.toString(five.searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));
    }
}
