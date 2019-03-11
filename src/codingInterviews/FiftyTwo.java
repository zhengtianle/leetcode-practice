package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-11
 * @Author ZhengTianle
 * Description:
 * 正则表达式匹配
 * https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class FiftyTwo {
    /**
     * 递归
     *
     * 1. 模式中第二个字符不是 *
     *      1)字符串第一个字符和模式串第一个字符匹配，则字符串和模式串都后移一位，递归匹配剩余串
     *      2)字符串第一个字符和模式串第一个字符不匹配，则直接返回false
     *
     * 2. 模式第二个字符是 *
     *      1)字符串第一个字符跟模式串第一个字符不匹配，则模式串后移两位，递归匹配剩余串
     *      2)字符串第一个字符跟模式串第一个字符匹配，有三种情况(*代表0,1或者1+)
     *          1)*代表0:  模式串后移两位，递归匹配剩余串
     *          2)*代表1:  模式串后移两位，字符串后移一位，递归匹配剩余串
     *          3)*代表1+: 字符串后移一位，递归匹配剩余串
     */
    public boolean match(char[] str, char[] pattern) {
        int strIndex = 0;
        int patternIndex = 0;
        return matchHelper(str, strIndex, pattern, patternIndex);
    }

    private boolean matchHelper(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if(strIndex >= str.length && patternIndex == pattern.length) {
            return true;
        }
        if(strIndex < str.length && patternIndex >= pattern.length) {
            return false;
        }
        //模式串第二个字符为*
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //字符串第一个字符跟模式串第一个字符匹配，有三种情况(*代表0,1或者1+)
            if(strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                // 1)*代表0:  模式串后移两位，递归匹配剩余串
                // 2)*代表1:  模式串后移两位，字符串后移一位，递归匹配剩余串
                // 3)*代表1+: 字符串后移一位，递归匹配剩余串
                return matchHelper(str, strIndex, pattern, patternIndex + 2) ||
                        matchHelper(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchHelper(str, strIndex +1, pattern, patternIndex);
            } else {
                //字符串第一个字符跟模式串第一个字符不匹配，则模式串后移两位，递归匹配剩余串
                return matchHelper(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式中第二个字符不是 *
        //字符串第一个字符和模式串第一个字符匹配，则字符串和模式串都后移一位，递归匹配剩余串
        if(strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
            return matchHelper(str, strIndex + 1, pattern, patternIndex + 1);
        }
        //字符串第一个字符和模式串第一个字符不匹配，则直接返回false
        return false;
    }
}
