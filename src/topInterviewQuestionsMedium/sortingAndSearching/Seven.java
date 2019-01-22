package topInterviewQuestionsMedium.sortingAndSearching;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-22
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/102/
 * 搜索旋转排序数组
 */
public class Seven {
    /**
     * 找到最小元素下标
     * 根据两个区间头筛选元素所在区间
     * 在选定的区间内进行二分查找
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }

        int left = 0;
        int right = 0;
        int mid = 0;
        if(minIndex == 0){//原数组没旋转
            left = 0;
            right = nums.length-1;
        } else if(target >= nums[minIndex] && target <= nums[nums.length-1]){//在右区间
            left = minIndex;
            right = nums.length-1;
        } else if(target >= nums[0] && target <= nums[minIndex-1]){//在左区间
            left = 0;
            right = minIndex-1;
        } else {//没找到
            return -1;
        }

        while(left <= right){
            mid = (left+right)/2;
            if(target > nums[mid])
                left = mid+1;
            else if(target < nums[mid])
                right = mid-1;
            else
                return mid;
        }
        return -1;
    }
}
