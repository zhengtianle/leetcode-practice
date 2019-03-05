package codingInterviews;

import com.sun.scenario.effect.Merge;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-5
 * @Author ZhengTianle
 * Description:
 * 数组中的逆序对
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 复制
 * 1,2,3,4,5,6,7,0
 * 输出
 * 复制
 * 7
 */
public class ThirtyFive {

    /**
     * O(n²)超时
     */
    public int InversePairs1(int [] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count%1000000007;
    }

    /**
     * O(nlogn) 归并排序思想
     *
     * 例如7,5,4,6可以划分为两段7,5和4,6两个子数组
     * 1. 在7,5中求出逆序对，因为7大于5所以有1对
     * 2. 在6,4中求出逆序对，因为6大于4所以逆序对再加1，为2
     * 3. 对7,5和6,4进行排序，结果为5,7,和4,6
     * 4. 设置两个指针分别指向两个子数组中的最大值，p1指向7，p2指向6
     * 5. 比较p1和p2指向的值，如果大于p2，因为p2指向的是最大值，所以第二个子数组中有几个元素就有几对逆序对
     *      (当前有两个元素，逆序对加2,2+2=4)，7>6,比较完之后将p1指向的值放入辅助数组里，辅助数组里现在有一个数字7，然后将p1向前移动一位指向5)
     * 6. 再次判断p1和p2指向的值，p1小于p2，因为p1指向的是第一个子数组中最大值，所以子数组中没有能和当前p2指向的6构成逆序对的数，
     *      将p2指向的值放入辅助数组，并向前移动一位指向4，此时辅助数组内为6,7
     * 7. 继续判断p1(指向5)和p2(指向4)，5>4,第二个子数组中只有一个数字，逆序对加1，4+1=5，为5对，然后将5放入辅助数组，
     *      第一个子数组遍历完毕，只剩下第二个子数组，当前只有一个4，将4也放入辅助数组，函数结束。辅助数组此时为4,5,6,7.逆序对为5.
     */
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1) {
            return 0;
        }
        return mergeSort(array, 0, array.length-1);
    }

    private int mergeSort(int[] array, int start, int end) {
        if(start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        //递归分别求左边子数组和右边子数组逆序对的个数
        int leftCount = mergeSort(array, start, mid);
        int rightCount = mergeSort(array, mid+1, end);

        int count = 0;//左边子数组相对于右边子数组的逆序对个数
        int leftIndex = mid;//左边子数组的最后一个元素位置
        int rightIndex = end;//右边子数组的最后一个元素位置
        int[] copyArray = new int[end - start + 1];
        int copyIndex = end - start;//辅助数组的最后一个元素位置
        while(leftIndex >= start && rightIndex >= mid + 1) {
            if(array[leftIndex] > array[rightIndex]) {
                //左边子数组最后一个元素 > 右边子数组最后一个元素
                count += rightIndex - mid;
                copyArray[copyIndex--] = array[leftIndex--];
                if(count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                //左边子数组最后一个元素 < 右边子数组最后一个元素
                copyArray[copyIndex--] = array[rightIndex--];
            }
        }
        while(leftIndex >= start) {
            copyArray[copyIndex--] = array[leftIndex--];
        }
        while(rightIndex >= mid + 1) {
            copyArray[copyIndex--] = array[rightIndex--];
        }

        copyIndex = 0;
        while(start <= end) {
            array[start++] = copyArray[copyIndex++];
        }

        return (count + leftCount + rightCount)%1000000007;
    }

}
