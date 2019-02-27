package codingInterviews;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-27
 * @Author ZhengTianle
 * Description:
 * 包含min函数的栈
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Twenty {
    /**
     * 一个主栈一个辅助栈
     * 压栈：
     *      主栈压栈
     *      当辅助栈为空时，辅助栈直接压栈
     *      当辅助栈不为空时，压栈元素与辅助栈栈顶元素比较，若压栈元素较小则压入辅助栈
     *
     * 出栈：
     *      主栈出栈
     *      当主栈栈顶元素与辅助栈栈顶元素相等时，辅助栈出栈
     *
     * min：
     *      辅助栈的栈顶元素即为当前最小元素
     */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minSatck = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(minSatck.isEmpty()) {
            minSatck.push(node);
        } else {
            if(node < minSatck.peek()) {
                minSatck.push(node);
            }
        }
    }

    public void pop() {
        if(stack.peek().equals(minSatck.peek())) {
            minSatck.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minSatck.peek();
    }
}
