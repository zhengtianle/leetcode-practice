package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-26
 * @Author ZhengTianle
 * Description:
 * 合并两个排序的链表
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Sixteen {
    /**
     * 两个指针分别用来遍历两个list
     * 每次两个指针指向的两个节点都要比较大小
     * 将比较中较小的节点插入结果链表末尾，较小节点指针后移
     * 直至某一list为空
     * 将还有未遍历过的节点直接插入到结果链表末尾
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        if(list1 != null) {
            result.next = list1;
        }
        if(list2 != null) {
            result.next = list2;
        }
        return head.next;
    }
}
