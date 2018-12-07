package topInterviewQuestionsEasy.others;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-7
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/68/
 */
public class Five {
    public boolean isValid(String s) {
        if(s == null)
            return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(stack.isEmpty()){
                stack.push(chars[i]);
            }else {
                //栈不为空
                //如果当前char和栈顶元素配对成功
                if(isPairing(stack.peek(), chars[i])){
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    public boolean isPairing(char c1, char c2){
        if(c1 == '[' && c2 == ']')
            return true;
        if(c1 == '(' && c2 == ')')
            return true;
        if(c1 == '{' && c2 == '}')
            return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
