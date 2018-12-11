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
    public String anotherLongestPalindrome(String s) {
        //null、""、单个字符
        if(s == null || s.length() == 0 || s.length() == 1)
            return s;
        //得到类似于#a#b#c#的字符串,字符串的位数一定是奇数（2*n + 1）
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length(); i++){
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#");
        char[] chars = sb.toString().toCharArray();
        int left;//左指针
        int right;//右指针
        int maxLen = 2;//最大长度-1
        int leftIndex = 0;//记录最大长度的左序号
        boolean flag;
        for(int i = 1; i < chars.length - 1; i++){
            left = i - 1;
            right = i + 1;
            flag = true;
            while(flag && left >= 0 && right < chars.length){
                if(chars[left] != chars[right]){
                    if(((right-1) - (left+1)) > maxLen){
                        leftIndex = left + 1;
                        maxLen = (right-1) - (left+1);
                    }
                    flag = false;
                } else if(left == 0 || right == chars.length - 1){
                    if((right - left) > maxLen){
                        leftIndex = left;
                        maxLen = right - left;
                    }
                }
                left--;
                right++;
            }//while
        }
        String[] results = String.valueOf(chars, leftIndex, maxLen + 1).split("#");
        sb.delete(0, sb.length() );
        for(int i = 0; i < results.length; i++){
            sb.append(results[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Five object = new Five();
        System.out.println(object.longestPalindrome("babad"));
    }
}
