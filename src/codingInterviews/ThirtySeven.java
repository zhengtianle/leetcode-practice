package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-6
 * @Author ZhengTianle
 * Description:
 * 数字在排序数组中出现的次数
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class ThirtySeven {
    /**
     * 理论上来说是要先判断升序降序，此题潜规则是升序
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array == null) {
            return 0;
        }
        return getLast(array, k) - getFirst(array, k) + 1;
    }

    private int getFirst(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(array[mid] < k) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }

    private int getLast(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(array[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return high;
    }

    /**
     * 另一种解法是直接二分法求k-0.5和k+0.5的位置，相减。
     * 原理是array里面全是整数，k-0.5和k+0.5正好是第一个k的前面以及最后一个k的后面
     */

    public static void main(String[] args) {
        ThirtySeven obj = new ThirtySeven();
        System.out.println(obj.getFirst(new int[]{1,2,3,3,3,3},3));
        System.out.println(obj.getLast(new int[]{1,2,3,3,3,3},3));
    }
}
