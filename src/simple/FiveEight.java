package simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 */
public class FiveEight {

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World   "));
    }
}
