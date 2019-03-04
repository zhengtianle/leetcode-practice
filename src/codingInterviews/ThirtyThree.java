package codingInterviews;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-4
 * @Author ZhengTianle
 * Description:
 * 丑数
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class ThirtyThree {
    /**
     * 除了1，丑数一定是之前的丑数 *2 或者 *3 或者 *5 得到的
     */
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) {
            return index;
        }
        int[] result = new int[index];
        result[0] = 1;//第一个丑数
        int u1 = 0;
        int u2 = 0;
        int u3 = 0;

        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[u1]*2, Math.min(result[u2]*3, result[u3]*5));
            if(result[i] == result[u1]*2) {
                u1++;
            }
            if(result[i] == result[u2]*3) {
                u2++;
            }
            if(result[i] == result[u3]*5) {
                u3++;
            }
        }
        return result[index-1];
    }
}
