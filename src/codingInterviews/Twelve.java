package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-24
 * @Author ZhengTianle
 * Description:
 * 数值的整数次方
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Twelve {
    /**
     * O（n）普通求法
     */
    public double Power(double base, int exponent) {
        if(base == 0) {
            return 0;
        }
        int unexponent = Math.abs(exponent);
        double result = 1.0;
        for(int i = 0; i < unexponent; i++) {
            result *= base;
        }
        if(exponent < 0) {
            result = 1/result;
        }
        return result;
    }

    /**
     * O(logn)快速幂算法
     * 例子：
     *  a^11 = a(2  ^ 0 + 2 ^ 1 + 2 ^ 3) = a ^(1011);
     */
    public double Power1(double base, int exponent) {
        if(base == 0) {
            return 0;
        }
        int unexponent = Math.abs(exponent);
        double result = 1.0;
        double cur = base;
        while(unexponent != 0) {
            if((unexponent & 1) == 1) {
                result *= cur;
            }
            cur *= cur;
            unexponent >>= 1;//右移一位
        }
        if(exponent < 0) {
            result = 1/result;
        }
        return result;
    }
}
