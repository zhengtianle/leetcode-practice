package random.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-12
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/word-break/
 * 139.单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class OneThreeNine {

    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示下标i-1结尾的字符串是否可以被wordDict拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    //可以分为0..j-1  和    j..i
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //递归，超出时间限制
    public boolean wordBreak1(String s, List<String> wordDict) {
        if(s.equals("")) return true;
        for(String word : wordDict) {
            if(s.indexOf(word) == 0) {
                if(wordBreak(s.substring(word.length()), wordDict)) return true;
            }
        }
        return false;
    }
}
