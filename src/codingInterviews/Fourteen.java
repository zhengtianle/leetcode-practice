package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-24
 * @Author ZhengTianle
 * Description:
 * 链表中倒数第k个结点
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Fourteen {
    /**
     * 双指针法，其中一个指针先行k-1步，然后两个指针同步前进，
     * 先行者到达最后一个结点，后行指针所指位置即为倒数第k个结点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode pre = head;
        ListNode suffix = head;
        int n = k-1;
        while(pre != null && n-- != 0) {
            pre = pre.next;
        }
        if(pre == null)
            return null;
        while(pre.next != null) {
            pre = pre.next;
            suffix = suffix.next;
        }
        return suffix;
    }
}
