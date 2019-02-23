package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-23
 * @Author ZhengTianle
 * Description:
 * 矩形覆盖
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Ten {
    /**
     * n = 1 : 1种
     * n = 2 : 2种
     * n = 3 :
     *          先竖着放一个2*1矩形，右边还剩两个2*1位置（构成一个2*2正方形），剩下的位置就是n=2的情况 : f(2)
     *          再尝试横着放一个2*1矩形，下边剩一个2*1，右边剩一个2*1。
     *              由于下边只能那样子放置，所以又剩下右边的2*1是n=1的情况 : f(1)
     * n = 4 : 竖放为f(3) 横放为f(2)
     * ……
     * n = n : 竖放为f(n-1) 横放为f(n-2)
     */
    public int RectCover(int target) {
        if(target <= 0)
            return 0;
        else if(target == 1 || target == 2)
            return target;
        else
            return RectCover(target-1) + RectCover(target-2);
    }
}
