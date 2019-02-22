package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-22
 * @Author ZhengTianle
 * Description:
 * 旋转数组的最小数字
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Six {
    /**
     * 二分法
     */
    public int minNumberRotateArray(int[] array) {
        if(array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length-1;
        int mid;
        while(left < right) {
            mid = (left + right)/2;
            if(array[right] < array[mid]) {
                //最小值在mid右边
                left = mid + 1;
            } else if (array[right] > array[mid]) {
                //最小值是mid或者在mid左边
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
