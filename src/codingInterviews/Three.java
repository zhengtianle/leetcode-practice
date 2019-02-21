package codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-21
 * @Author ZhengTianle
 * Description:
 * 从尾到头打印链表
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Three {
    /**
     * 先反转链表，再挨个加入list
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = null;
        ListNode temp = null;
        while(listNode != null){//翻转链表
            temp = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = temp;
        }
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
