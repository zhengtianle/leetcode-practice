package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-10
 * @Author ZhengTianle
 * Description:
 * 把字符串转换成整数
 * https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 复制
 * 2147483647
 *     0
 */
public class FourtyNine {
    public int StrToInt(String str) {
        if(str == null || str.length() <= 0) {
            return 0;
        }
        char[] string = str.toCharArray();
        int res = 0;
        int positive = 1;
        for (int i = 0; i < string.length; i++) {
            if(i == 0) {
                if(string[i] == '+') {
                    positive = 1;
                    continue;
                } else if(string[i] == '-') {
                    positive = -1;
                    continue;
                }
            }
            if(string[i] >= '0' && string[i] <= '9') {
                res = res * 10 + string[i] - '0';
            } else {
                return 0;
            }
        }
        return res * positive;
    }
}
