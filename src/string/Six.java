package string;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-16
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/37/
 */
public class Six {

    public static int myAtoi(String str){
        //正负标志位，默认值为正
        int sign = 1;
        //结果值，初始值为0
        long number = 0;
        int i = 0;
        int j = 0;
        if(str == null || "".equals(str))
            return 0;
        int len = str.length();
        //找到第一个不是空格的下标
        for(; i < len; i++){
            if(!Character.isSpaceChar(str.charAt(i)))
                break;
        }
        if(i == len)
            return 0;
        //判断这个字符
        char c = str.charAt(i);
        if (c == '-' || c == '+')//+ -
            sign = c == '-' ? -1 : 1;
        else if(Character.isDigit(c))//数字
            number = 10 * number + str.charAt(i) - '0';
        else{
            //不能有效转换
            return 0;
        }



        //下一位开始遍历
        //是数字并且未越界
        j = i;
        while(++j < len && Character.isDigit(str.charAt(j))){
            number = 10 * number + str.charAt(j) - '0';
            if(number*sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(number*sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int)number * sign;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(null));
        System.out.println(myAtoi("   "));
        System.out.println(myAtoi("999999999999999999999999999999999999999999999999999999"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("w987"));
        System.out.println(myAtoi("-91283472332"));
    }
}
