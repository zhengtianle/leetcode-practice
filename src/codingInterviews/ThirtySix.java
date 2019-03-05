package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-5
 * @Author ZhengTianle
 * Description:
 * 两个链表的第一个公共结点
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class ThirtySix {
    //链表呈Y形状
    /**
     * 方法一 哈希法
     */
    //略
    /**
     * 方法二 双指针法
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        //求两个链表的长度
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }

        p1 = pHead1;
        p2 = pHead2;
        if(len1 > len2) {
            for(int i = 0; i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else if(len1 < len2) {
            for(int i = 0; i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }

        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
