package random.simple;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-2
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/description/
 */
public class EightEightFour {

    /**
     * 解题：在两个句子组成的字符串里某单词出现频率为1
     */
    public static String[] uncommonFromSentences(String A, String B) {
        String whole = A + " " + B;
        String[] words = whole.split(" ");
        String[] result = new String[words.length];
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.merge(word, 1, (x, y) -> x + y);
        }

        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result[i++] = entry.getKey();
            }
        }

        return Arrays.copyOf(result, i);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("d b zu d t", "udb zu ap")));
    }
}
