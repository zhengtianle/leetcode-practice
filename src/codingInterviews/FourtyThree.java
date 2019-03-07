package codingInterviews;



/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-7
 * @Author ZhengTianle
 * Description:
 * 左旋转字符串
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class FourtyThree {
    /**
     * 截取拼接
     */
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() <= 1) {
            return str;
        }
        if(n >= str.length()) {
            n %= str.length();
        }
        return str.substring(n, str.length()) + str.substring(0, n);
    }

    /**
     * 三次翻转
     */
    public String LeftRotateString1(String str, int n) {
        if(str == null || str.length() <= 1) {
            return str;
        }
        char[] string = str.toCharArray();
        reverse(string, 0, n - 1);
        reverse(string, n, string.length - 1);
        reverse(string, 0, string.length - 1);
        return new String(string);
    }

    private void reverse(char[] string, int start, int end) {
        char tmp;
        while(start < end) {
            tmp = string[start];
            string[start] = string[end];
            string[end] = tmp;
            start++;
            end--;
        }
    }

}
