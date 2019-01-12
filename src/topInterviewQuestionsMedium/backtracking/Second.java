package topInterviewQuestionsMedium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-12
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/92/
 * 生成括号
 */
public class Second {

    /**
     * 注意生成的是有效的括号组合
     * 有效题解：
     * 可以添加右括号：左括号个数 > 右括号个数
     * 可以添加左括号：左括号个数 < n
     * 生成一个组合：右括号个数 == n
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        generateBrackets(result, "", 0, 0, n);
        return result;
    }

    /**
     * 核心函数
     * @param result 结果集
     * @param s 生成的括号字符串
     * @param leftCount 左括号个数
     * @param rightCount 右括号个数
     * @param n 题目中要求生成括号的对数
     */
    public void generateBrackets(List<String> result, String s, int leftCount, int rightCount, int n){
        //生成一个组合：右括号个数 == n
        if(rightCount == n){
            result.add(s);
            return;
        }
        //可以添加左括号：左括号个数 < n
        if(leftCount < n){
            generateBrackets(result, s+"(", leftCount+1, rightCount, n);
        }

        //可以添加右括号：左括号个数 > 右括号个数
        if(leftCount > rightCount){
            generateBrackets(result, s+")", leftCount, rightCount+1, n);
        }
    }
}
