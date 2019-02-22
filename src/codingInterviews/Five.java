package codingInterviews;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-22
 * @Author ZhengTianle
 * Description:
 * 用两个栈实现队列
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Five {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 直接push到栈1中即可
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 将栈1中的元素按栈的顺序push到栈2中
     * 这个操作每当栈2为空时进行一次
     * 非空的栈2的顶部元素即为所要取的元素
     */
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
