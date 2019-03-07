package codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-7
 * @Author ZhengTianle
 * Description:
 * 和为S的连续正数序列
 * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FourtyOne {
    /**
     * 双指针法
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int low = 1;
        int high = 2;
        int currentSum = 0;
        while(low < high) {
            currentSum = (low + high) * (high - low + 1) / 2;//等差数列求和公式
            if(currentSum == sum) {
                ArrayList<Integer> innerList = new ArrayList<>();
                for(int i = low; i <= high; i++) {
                    innerList.add(i);
                }
                list.add(innerList);
                low++;
            } else if (currentSum < sum) {
                high++;
            } else {
                low++;
            }
        }
        return list;
    }

    /**
     * 也可以用数学法求解
     * 列出方程，逐个试验low，得出high
     */

    /**
     * 另一种数学思路
     * S为正整数序列，此序列是一个公差为1的等差序列
     *，所以这个序列的中间值代表了平均值的大小
     * 假设序列长度为n，中间值则为S/n
     *
     * n为奇数时（(n & 1) == 1）： 序列中间的值是序列的平均值，也就是 sum%n == 0
     * n为偶数时（(n & 1) != 1）：序列中间两个值的平均值为序列的平均值，也就是 (sum%n)*2 == n
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //等差数列的求和公式：S = (1 + n) * n / 2，得到 n < √(2S)
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
