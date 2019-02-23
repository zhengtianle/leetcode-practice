package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-23
 * @Author ZhengTianle
 * Description:
 * 二进制中1的个数
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Eleven {
    /**
     * 一个思路清奇的解法
     */
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0","").length();
    }

    /**
     * 位运算
     */
    public int NumberOf1a(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;//无视符号位的右移一位，如果使用>>，负数左边使用1来填充会造成死循环
        }
        return count;
    }

    /**
     * 位运算更优解
     */
    public int NumberOf1b(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        Eleven eleven = new Eleven();
        System.out.println(eleven.NumberOf1b(-1));//32个
    }
}
