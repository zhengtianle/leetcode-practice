package topInterviewQuestionsMedium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-12
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/91/
 * 电话号码的字母组合
 */
public class First {
    private String[] tel = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }

        backTrack(digits, 0, result);
        return result;
    }

    public void backTrack(String digits, int index, List<String> result){
        if(index == digits.length()){//表明完成一个组合
            result.add(sb.toString());
            return;
        }

        String s = tel[digits.charAt(index)-'0'];
        for(int i = 0;i < s.length();i++){
            sb.append(s.charAt(i));
            backTrack(digits, index+1, result);
            sb.delete(index,sb.length());//删除从此次循环加的第一个字符到最后一个字符
        }
    }
}
