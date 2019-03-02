package codingInterviews;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-2
 * @Author ZhengTianle
 * Description:
 * 字符串的排列
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class TwentySeven {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() <= 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(chars, 0, str.length(), sb, list);
        Collections.sort(list);
        return list;
    }

    private void helper(char[] chars, int count, int length, StringBuilder sb, ArrayList<String> list) {
        if(count == length) {
            if(!list.contains(sb.toString())) {
                list.add(sb.toString());
            }
            return;
        }
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '0') {
                continue;
            }
            sb.append(chars[i]);
            char tmp = chars[i];
            chars[i] = '0';
            helper(chars, count+1, length, sb, list);
            chars[i] = tmp;
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
