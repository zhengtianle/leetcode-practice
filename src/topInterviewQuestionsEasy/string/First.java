package topInterviewQuestionsEasy.string;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-15
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
 */
public class First {
    /*StringBuilder解法---慢*/
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*char[]解法---快*/
    public static String anotherReverseString(String s){
        char[] result = new char[s.length()];
        int j = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            result[j++] = s.charAt(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
        System.out.println(anotherReverseString("A man, a plan, a canal: Panama"));
    }
}
