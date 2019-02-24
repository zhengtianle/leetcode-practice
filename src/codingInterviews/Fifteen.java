package codingInterviews;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-24
 * @Author ZhengTianle
 * Description:
 * 翻转链表
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Fifteen {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = null;
        ListNode result = null;
        while(head != null) {
            temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }
}
