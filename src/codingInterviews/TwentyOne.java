package codingInterviews;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-27
 * @Author ZhengTianle
 * Description:
 * 栈的压入、弹出序列
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class TwentyOne {
    /**
     * 模拟出栈过程
     * 借助一个辅助栈
     * 将pushA元素循环内依次压入栈
     * 每压栈一次，判断popA遍历指针所指元素（刚开始指向第一个元素）是不是和pushA栈顶元素相同
     * 若相同则出栈并将popA遍历指针后移一位
     * 全部遍历完之后，若辅助栈为空，则模拟成功，返回true，否则false
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && (stack.peek().equals(popA[j]))) {
                j++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
