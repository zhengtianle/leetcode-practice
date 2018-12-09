package topInterviewQuestionsMedium.arrayAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-8
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
 */
public class Four {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int index = 0;
        int left = 0;
        while(index < s.length()){
            if(!set.contains(s.charAt(index))){
                set.add(s.charAt(index));
                index++;
                max = Math.max(max, set.size());
            } else {
                //遇到重复字符
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

}
