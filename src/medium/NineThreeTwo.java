package medium;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-1
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/contest/weekly-contest-108/problems/beautiful-array/
 */
public class NineThreeTwo {

    /**
     * A[k]*2 != A[i]+A[j]
     * 则
     * (A[k]-x)*2 != A[i]-x + A[j]-x    --->    减去一个数仍然是漂亮数组
     * A[k]*2*x != (A[i]+A[j])*x = A[i]*x + A[j]*x  --->    乘上一个数仍然是漂亮数组
     */
    public static int[] beautifulArray(int N) {
        int[] result = new int[1];
        result[0] = 1;

        while(result.length < N){
            int newLength = result.length*2;
            int[] newResult = new int[newLength];
            int j = 0;
            for(int i : result){
                newResult[j++] = i*2-1;
            }
            for(int i : result){
                newResult[j++] = i*2;
            }

            result = newResult;
        }
        int[] ans = new int[N];
        int j = 0;
        for(int i : result){
            if(i <= N){
                ans[j++] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray(5)));
    }
}
