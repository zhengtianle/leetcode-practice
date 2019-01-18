package topInterviewQuestionsMedium.sortingAndSearching;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-18
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/98/
 * 数组中的第K个最大元素
 */
public class Three {
    /**
     * 借鉴快排的思路，左边放大的，右边放小的
     * 如果枢轴的位置为k-1（枢轴左边有k-1个数），则此时的枢轴处所对应的值即为所求值
     */
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        int position = 0;
        while(low <= high){
            position = partition(nums, low, high);
            if(position == k-1) break;
            else if (position > k-1) high = position-1;
            else low = position+1;
        }

        return nums[position];
    }

    public int partition(int[] nums, int low, int high){
        int pivotkey = nums[low];
        while(low < high){
            while(low < high && nums[high] <= pivotkey) --high;//小的放右边
            nums[low] = nums[high];
            while(low < high && nums[low] >= pivotkey) ++low;//大的放左边
            nums[high] = nums[low];
        }
        nums[low] = pivotkey;
        return low; //返回枢轴位置
    }

    /**
     * 利用（小顶堆）优先队列
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();//默认小顶堆
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k)
                queue.poll();//删除队首元素/最小元素
        }
        return queue.peek();//返回队首元素
    }
}
