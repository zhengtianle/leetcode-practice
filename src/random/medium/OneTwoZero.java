package random.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-5
 * @Author ZhengTianle
 * Description:
 */
public class OneTwoZero {

    /**
     * 一种思路从上向下遍历，每次把上一层的数加到下一层的数上（取最小值）
     * 比如题目中的第2、3层，5选择加3更小，所以5变成5+3
     * 最后遍历最后一层最小值即可得到答案
     *
     * 第二种思路从下向上遍历，每次把下一层的数加到上一层的数上（同理取最小值）
     * 最后第一层的数即为答案
     *
     * 上面两种遍历方式显然第二种更好（不需要最后再遍历判断一次）
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[j]代表某一层j位置的相加最小值
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                //这时候dp[j]和dp[j+1]都是i+1时遍历计算后的dp,相当于此层的下一层
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        OneTwoZero obj = new OneTwoZero();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        obj.minimumTotal(Arrays.asList(list1, list2, list3, list4));
    }
}
