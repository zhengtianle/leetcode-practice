package topInterviewQuestionsMedium.arrayAndStrings;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-9
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
 */
public class Five {
    /**
     * 动态规划
     *
     * f(i, j) = {
     *     true                         i = j
     *     s[i] = s[j]                  j = i + 1
     *     s[i] = s[j] && f(i+1, j-1)   j > i + 1
     * }
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1)
            return s;

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;

        char[] chars = s.toCharArray();
        //f[i][j]表示chars[i]到chars[j]是不是回文串
        boolean[][] f = new boolean[chars.length][chars.length];
        for(int j = 0; j < chars.length; j++){
            for(int i = 0; i <= j; i++){
                f[i][j] = (chars[i] == chars[j]) && ((j - i < 2) || f[i+1][j-1]);
                if(f[i][j]){
                    if(j - i > max){
                        max = j - i;
                        left = i;
                        right = j;
                    }//if(j - i > max)
                }//if(f[i][j])
            }//for i
        }//for j

        return String.valueOf(chars, left, right - left + 1);
    }

    /**
     * 在每个字符的左右两边填充字符然后在从各个中心向左右两边遍历
     * abc ---> #a#b#c#
     */


    public static void main(String[] args) {
        Five object = new Five();
        System.out.println(object.longestPalindrome("babad"));
    }
}
