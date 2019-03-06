package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-6
 * @Author ZhengTianle
 * Description:
 * 数组中只出现一次的数字
 * https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class Fourty {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    /**
     * 第一种解法，HashMap，略
     * 第二种解法，将数组分成两部分，每个子数组除了一个数字外(求的两个数字中的一个)，其他数字都出现偶数次
     * 怎么分？
     * 全体异或，最后得数为n
     * n一定不等于0，找n的二进制其中一位为1的位数，以此分成两个数组（此位为0的一组，此位为1的一组）
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //异或
        int n = 0;
        for(int a : array) {
            n ^= a;
        }

        //分组异或
        int index = 0;
        while((n & 1) == 0) {
            n >>= 1;
            index++;
        }

        for(int a : array) {
            if(((a >> index) & 1) == 1) {
                num1[0] ^= a;
            } else {
                num2[0] ^= a;
            }
        }
    }
}
