package codingInterviews;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-11
 * @Author ZhengTianle
 * Description:
 * 表示数值的字符串
 * https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class FiftyThree {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }

        boolean e = false;
        boolean dot = false;

        for (int i = 0; i < str.length; i++) {
            if(str[i] == 'e' || str[i] == 'E') {
                if(i == str.length - 1 || e) {
                    //e后面必须有数字
                    //e不能出现两次
                    return false;
                }
                e = true;
            } else if (str[i] == '+' || str[i] == '-') {
                //+ 或者 - 只能出现在开头或者e的后面第一个字符
                if(i == 0 || (e && (str[i - 1] == 'e' || str[i - 1] == 'E'))) {
                    continue;
                }
                return false;
            } else if(str[i] == '.') {
                //.不能出现在e的后面，也不能出现两次
                if(e || dot) {
                    return false;
                }
                dot = true;
            } else if(str[i] < '0' || str[i] > '9') {
                //其他的非0-9字符均为不合法
                return false;
            }
        }
        return true;
    }

}
