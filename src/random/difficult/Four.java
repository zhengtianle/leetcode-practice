package random.difficult;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-13
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 寻找两个有序数组的中位数
 */
public class Four {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        for(int i = 0;i < nums2.length;i++){
            nums[nums1.length+i] = nums2[i];
        }

        Arrays.sort(nums);
        if(nums.length%2 == 0){//偶数个
            return (nums[nums.length/2 - 1] + nums[nums.length/2])/2.0;
        } else {
            return nums[nums.length/2];
        }
    }

    public static void main(String[] args) {
        int x, y;
        x = 5;
        y = 3;
        System.out.println(x/y);
    }
}
