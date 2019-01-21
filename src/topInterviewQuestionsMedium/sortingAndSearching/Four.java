package topInterviewQuestionsMedium.sortingAndSearching;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-21
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/99/
 * 寻找峰值
 */
public class Four {

    /**
     * 二分法
     * nums[i+1] > nums[i]则，峰值一定在右边
     * nums[i-1] > nums[i]则，峰值一定在左边
     * 因为两边的断电nums[-1]和nums[n]都是负无穷
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid+1] > nums[mid]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.findPeakElement(new int[]{1,2,3,1}));
    }

}
