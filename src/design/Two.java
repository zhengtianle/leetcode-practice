package design;

import org.w3c.dom.NodeList;

import javax.xml.soap.Node;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/59/
 */
public class Two {
    private int min;            //记录最小值
    private NodeList head;      //空头指针
    private boolean isPopMin;

    /** initialize your data structure here. */
    public Two() {
        head = new NodeList();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        isPopMin = false;
        NodeList node = new NodeList();
        node.value = x;
        node.next = head.next;
        head.next = node;
        if(x < min){
            min = x;
            //pop的第一个元素为最小值
            isPopMin = true;
        }

    }

    public void pop() {
        head.next = head.next.next;
        if(isPopMin){
            //如果pop的正好是最小值，那么重新计算一下
            calcMin();
        }
        if(head.next.value == min)
            isPopMin = true;
    }

    public int top() {
        return head.next.value;
    }

    public int getMin() {
        return min;
    }

    public void calcMin(){
        min = Integer.MAX_VALUE;
        NodeList p = head;
        while(p.next != null){
            if(p.next.value < min)
                min = p.next.value;
            p = p.next;
        }
        if(head.next.value != min)
            isPopMin = false;
    }


    class NodeList{
        int value;
        NodeList next;
    }
}
