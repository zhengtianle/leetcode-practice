package codingInterviews;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-24
 * @Author ZhengTianle
 * Description:
 * 调整数组顺序使奇数位于偶数前面
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Thirteen {
    public void reOrderArray(int [] array) {
        int[] result = new int[array.length];
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {
                result[j++] = array[i];
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                result[j++] = array[i];
            }
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    public static void main(String[] args) {
        Thirteen obj = new Thirteen();
        int[] array = {1,2,3,4,5,6,7};
        obj.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
