package codingInterviews;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-13
 * @Author ZhengTianle
 * Description:
 * 链表中环的入口节点
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class FiftyFive {
    /**
     * 哈希
     */
    HashSet<ListNode> set = new HashSet<>();
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        while(pHead != null) {
            if(set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
            }
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 双指针法
     * p1 p2都从头开始走，p1每次走一步，p2每次走两步，直到p1==p2（相汇）
     * 设p1走了x步，则p2走了2x步，环共有n个节点 -> x+kn=2x，所以x=kn，也就是p1走了整数个环的距离
     * 此时将p2重置头部，p1 p2同时一步一步走，p1==p2时，此节点为环的入口节点(画图可证得)
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
        while(p1 != p2) {
            if(p2 == null || p2.next == null) return null;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p2 = pHead;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
