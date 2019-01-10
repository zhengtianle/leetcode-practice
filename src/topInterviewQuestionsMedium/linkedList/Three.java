package topInterviewQuestionsMedium.linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-10
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/84/
 * 相交链表
 */
public class Three {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        int lenA = 0;
        int lenB = 0;
        ListNode pa = headA;
        ListNode pb = headB;

        //求AB长度
        while(pa != null){
            lenA++;
            pa = pa.next;
        }
        while(pb != null){
            lenB++;
            pb = pb.next;
        }

        pa = headA;
        pb = headB;
        int diff;

        //将两个链表右端对齐
        if(lenA > lenB){
            diff = lenA - lenB;
            while(diff != 0){
                pa = pa.next;
                diff--;
            }
        } else if(lenA < lenB){
            diff = lenB - lenA;
            while(diff != 0){
                pb = pb.next;
                diff--;
            }
        }

        //pa pb遍历，遇到相等的值即为交点
        while(pa != null){
            if(pa == pb){
                break;
            }
            pa = pa.next;
            pb = pb.next;
        }

        return pa;

    }


}
