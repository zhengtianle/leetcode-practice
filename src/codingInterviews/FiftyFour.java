package codingInterviews;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-13
 * @Author ZhengTianle
 * Description:
 * 字符流中第一个不重复的数字
 * https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FiftyFour {
    /**
     * 哈希
     */
    StringBuilder sb = new StringBuilder();
    HashMap<Character, Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if(map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] string = sb.toString().toCharArray();
        for (int i = 0; i < string.length; i++) {
            if(map.get(string[i]) == 1) {
                return string[i];
            }
        }
        return '#';
    }
}
