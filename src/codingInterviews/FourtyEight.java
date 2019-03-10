package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-10
 * @Author ZhengTianle
 * Description:
 * 不做加减乘除做加法
 * https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class FourtyEight {
    /**
     * 不让用加减乘除典型让用位运算啊
     *
     * 本来的思路是一位一位的判断，进位……
     *
     * 后来发现网友们的“知识普及”：
     *
     * 首先看十进制是如何做的： 5+7=12，三步走
     * 第一步：相加各位的值，不算进位，得到2。
     * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
     * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
     *
     * 同样我们可以用三步走的方式计算二进制值相加：
     * 5->101，7->111
     * 第一步：相加各位的值，不算进位，得到010，重点！！！-> 二进制每位相加就相当于各位做异或操作，101^111。
     *
     * 第二步：计算进位值，得到1010，重点！！！-> 相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
     *
     * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为(010&1010)<<1 = 100
     *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     */
    public int Add(int num1,int num2) {
       int low = num1 ^ num2;
       int high = (num1 & num2) << 1;
       int tmp;
       while(high != 0) {
           tmp = low ^ high;
           high = (low & high) << 1;
           low = tmp;
       }
       return low;
    }
}
