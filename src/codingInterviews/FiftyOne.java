package codingInterviews;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-11
 * @Author ZhengTianle
 * Description:
 * 构建乘积数组
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class FiftyOne {
    /**
     * B0: 1  A1 A2 A3 A4
     * B1: A0 1  A2 A3 A4
     * B2: A0 A1 1  A3 A4
     * B3: A0 A1 A2 1  A4
     * B4: A0 A1 A2 A3 1
     *
     * 以左上右下对角线为分界
     * 先求左下区域三角
     * 再求右上区域三角
     */
    public int[] multiply(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int[] B = new int[A.length];

        //求左下区
        left[0] = 1;
        for(int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] * A[i - 1];
        }

        //求右上区
        right[A.length - 1] = 1;
        for(int i = A.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }

        //左右相乘即为B
        for(int i = 0; i < A.length; i++) {
            B[i] = left[i] * right[i];
        }
        return B;
    }

    public static void main(String[] args) {
        FiftyOne obj = new FiftyOne();
        System.out.println(Arrays.toString(obj.multiply(new int[]{-2, 1})));
    }
}
