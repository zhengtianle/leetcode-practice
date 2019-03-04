package codingInterviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-4
 * @Author ZhengTianle
 * Description:
 * 把数组排成最小的数
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ThirtyTwo {
    /**
     * 比较前后两个数字，如果拼接为 前后 > 后前 则把两个数字交换
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 1)
            return String.valueOf(numbers[0]);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        list.sort((s1, s2) -> {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str1.compareTo(str2);
        });
        list.forEach(sb::append);
        return sb.toString();
    }
}
