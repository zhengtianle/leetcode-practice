package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-10
 * @Author ZhengTianle
 * Description:
 * 求1+2+3+……+n
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class FourtySeven {
    /**
     * 短路与做终止条件 递归
     */
    public int Sum_Solution(int n) {
        int res = n;
        boolean flag = (res > 0) && ((res += Sum_Solution(n-1)) > 0);
        return res;
    }
}
