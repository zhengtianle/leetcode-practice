package medium;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/description/
 * Author: ZhengTianle
 */
public class NineThreeZero {

    public static int numSubarraysWithSum(int[] A, int S) {
        int num=0;
        for(int i = 0;i < A.length; i++){
            int ans=0;
            for(int j = i;j < A.length; j++){
                ans += A[j];
                if(ans == S){//判断累加后的值是否为期待值，若是则子数组个数自增
                    ++num;
                }
                if(ans > S){//大于期待值直接中断循环
                    break;
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}

